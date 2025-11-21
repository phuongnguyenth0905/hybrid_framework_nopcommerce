package pageObjectsWordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsWordpress.LoginPageUI;


public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
 		this.driver = driver;
	}

	public void inputToUsernameTextbox(String usernameOrEmail) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX, usernameOrEmail);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
	}

	public boolean isEmptyEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public boolean isEmptyPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
	}

	public boolean isInvalidPasswordErrorMEssageDisplaed() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
	}

}
