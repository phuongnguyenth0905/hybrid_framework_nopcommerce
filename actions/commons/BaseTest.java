package commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import io.qameta.allure.Attachment;

public class BaseTest {
	WebDriver driver;
	
	protected final Logger log;

	protected BaseTest() {
		log = LogManager.getLogger(getClass());
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
			System.setProperty("webdriver.edge.driver", GlobalConstants.ROOT_FOLDER + File.separator + "browserDriver" + File.separator + "msedgedriver.exe");
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
		BrowserEnum browser = BrowserEnum.valueOf(browserName.trim().toUpperCase());

		switch (browser) {

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.addArguments("--disable-notifications");
			ffOptions.addPreference("dom.webnotifications.enabled", false);
			System.setProperty("webdriver.firefox.logfile", GlobalConstants.BROWSER_LOG_FOLDER + "FirefoxDriver.log");
			System.setProperty("webdriver.firefox.verboseLogging", "true");
			driver = new FirefoxDriver(ffOptions);
			break;

		case CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-infobars");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enable", false);
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.logfile", GlobalConstants.BROWSER_LOG_FOLDER + "ChromeDriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			driver = new ChromeDriver(options);
			break;

		case EDGE_CHROMIUM:
			System.out.println("Driver path = " + GlobalConstants.ROOT_FOLDER + File.separator + "browserDriver" + File.separator + "msedgedriver.exe");
			EdgeOptions edgeOptions = new EdgeOptions();
			// Các option tương tự Chrome
			edgeOptions.addArguments("--disable-notifications");
			edgeOptions.addArguments("--start-maximized");
			edgeOptions.addArguments("--disable-infobars");
			edgeOptions.addArguments("--remote-allow-origins=*");

			Map<String, Object> edgePrefs = new HashMap<>();
			edgePrefs.put("credentials_enable_service", false);
			edgePrefs.put("profile.password_manager_enable", false);
			edgeOptions.setExperimentalOption("prefs", edgePrefs);
			System.setProperty("webdriver.edge.logfile", GlobalConstants.BROWSER_LOG_FOLDER + "EdgeDriver.log");
			System.setProperty("webdriver.edge.verboseLogging", "true");
			driver = new EdgeDriver(edgeOptions);
			break;
		case COCCOC:
			System.out.println("Driver path = " + GlobalConstants.ROOT_FOLDER + File.separator + "browserDriver" + File.separator + "chromedriver.exe");
			ChromeOptions optionsC = new ChromeOptions();
			optionsC.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(optionsC);
			break;
			case OPERA:
				System.out.println("Driver path = " + GlobalConstants.ROOT_FOLDER + File.separator + "browserDriver" + File.separator + "operadriver.exe");
				ChromeOptions optionsO = new ChromeOptions();
				optionsO.setBinary("C:\\Users\\Min Min\\AppData\\Local\\Programs\\Opera\\opera.exe"); 
				// sửa path theo thư mục Opera trên máy bạn

//				optionsO.addArguments("--remote-allow-origins=*");
//				optionsO.addArguments("--start-maximized");
				System.setProperty("webdriver.chrome.logfile", GlobalConstants.BROWSER_LOG_FOLDER + "CocCocDriver.log");
				System.setProperty("webdriver.chrome.verboseLogging", "true");

				 driver = new ChromeDriver(optionsO);
				break;
		default:
			throw new RuntimeException("Please input a supported browser!");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		//driver.manage().window().maximize();
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
