package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	//PageGeneratorManager pageGenerator;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		//pageGenerator=PageGeneratorManager.getPageGenerator();
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementClickable(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementClickable(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public void enterToPasswordTextbox(String password) {
		waitForElementClickable(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
	}
	public String getSuccessMessageText() {
	    return getElementText(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);

	}
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}
	public void inputToCompanyTexbox(String companyName) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyName);

	}
}
