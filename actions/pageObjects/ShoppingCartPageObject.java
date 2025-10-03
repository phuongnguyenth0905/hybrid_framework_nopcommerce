package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.AboutUsPageUI;
import pageUIs.CustomerInfoPageUI;
import pageUIs.NewsPageUI;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage{
	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
