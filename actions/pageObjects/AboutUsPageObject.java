package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.AboutUsPageUI;
import pageUIs.CustomerInfoPageUI;
import pageUIs.HomePageUI;
import pageUIs.NewsPageUI;

public class AboutUsPageObject extends BasePage{
	WebDriver driver;

	public AboutUsPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
