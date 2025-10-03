package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage{
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFistNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
	}
}
