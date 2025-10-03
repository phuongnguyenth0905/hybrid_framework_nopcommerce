package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;
import pageUIs.NewsPageUI;
import pageUIs.ShoppingCartPageUI;

public class NewsPageObject extends BasePage{
	WebDriver driver;

	public NewsPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
