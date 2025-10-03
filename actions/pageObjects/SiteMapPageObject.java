package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NewsPageUI;
import pageUIs.SiteMapPageUI;

public class SiteMapPageObject extends BasePage{
	WebDriver driver;

	public SiteMapPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
