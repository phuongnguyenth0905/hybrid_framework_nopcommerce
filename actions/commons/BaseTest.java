package commons;

import java.time.Duration;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

public class BaseTest {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	protected final Logger log;

	protected BaseTest() {
		log= LogManager.getLogger(getClass());
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
	
}
