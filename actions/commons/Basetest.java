package commons;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserEnum browser = BrowserEnum.valueOf(browserName.toUpperCase());
		if (browser == BrowserEnum.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == BrowserEnum.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BrowserEnum.EDGE_CHROMIUM) {
			 //WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", projectLocation + "\\browserDriver\\msedgedriver.exe");
			//WebDriverManager.edgedriver().cachePath("browserDriver").setup();
			 //WebDriverManager.edgedriver().cachePath(projectLocation + "\\browserDriver").setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input the browser name!");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
			 //WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", projectLocation + "\\browserDriver\\msedgedriver.exe");
			//WebDriverManager.edgedriver().cachePath("browserDriver").setup();
			 //WebDriverManager.edgedriver().cachePath(projectLocation + "\\browserDriver").setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input the browser name!");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;

	}
	protected int getRandom() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
