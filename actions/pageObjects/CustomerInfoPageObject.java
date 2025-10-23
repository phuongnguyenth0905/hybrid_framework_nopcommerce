package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameTextboxValue() {
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

	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttributeByName(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsletterCheckboxSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.NEWSLETTER_TEXTBOX);
		return isElementSelected(driver, CustomerInfoPageUI.NEWSLETTER_TEXTBOX);
	}
}
