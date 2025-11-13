package commons;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

public class BaseTest {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	protected final Logger log;

	protected BaseTest() {
		log= LogManager.getLogger(getClass());
	}
	@BeforeMethod
	public void beforeMethod(Method method) {
	    log.info("=== START TEST: " + method.getName() + " ===");
	}
	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] takeScreenshot(WebDriver driver) {
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public WebDriver getDriver() {
		return driver;
	}
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserEnum browser = BrowserEnum.valueOf(browserName.toUpperCase());
		if (browser == BrowserEnum.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == BrowserEnum.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BrowserEnum.EDGE_CHROMIUM) {
			// WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", projectLocation + "\\browserDriver\\msedgedriver.exe");
			// WebDriverManager.edgedriver().cachePath("browserDriver").setup();
			// WebDriverManager.edgedriver().cachePath(projectLocation +
			// "\\browserDriver").setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input the browser name!");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		return driver;

	}

	protected WebDriver getBrowserDriver(String browserName, String url) {
		BrowserEnum browser = BrowserEnum.valueOf(browserName.toUpperCase());
		if (browser == BrowserEnum.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == BrowserEnum.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BrowserEnum.EDGE_CHROMIUM) {
			// WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", projectLocation + "\\browserDriver\\msedgedriver.exe");
			// WebDriverManager.edgedriver().cachePath("browserDriver").setup();
			// WebDriverManager.edgedriver().cachePath(projectLocation +
			// "\\browserDriver").setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input the browser name!");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		return driver;

	}

	protected int getRandom() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			}
		return pass;
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
            log.error("❌ FAILED: " + result.getName());
            log.error("➡ Reason: " + result.getThrowable().getMessage());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            log.info("✅ PASSED: " + result.getName());
        }
	}
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
