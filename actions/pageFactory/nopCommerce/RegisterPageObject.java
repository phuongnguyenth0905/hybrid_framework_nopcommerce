package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject  extends BasePage{
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this); 
	}
	@FindBy(id="FirstName")
	private WebElement firstNameTextbox;
	@FindBy(id="LastName")
	private WebElement lastNameTextbox;
	@FindBy(id="Email")
	private WebElement emailTextbox;
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	@FindBy(id="ConfirmPassword")
	private WebElement confirmpasswordTextbox;
	@FindBy(id="register-button")
	private WebElement registerButton;
	@FindBy(xpath="//div[@class='result' and text()='Your registration completed']")
	private WebElement registersuccessMessage;
	@FindBy(css=".ico-logout")
	private WebElement logoutLink;
	
	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		senKeyToElement(driver, firstNameTextbox, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		senKeyToElement(driver, lastNameTextbox, lastName);

	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		senKeyToElement(driver, emailTextbox, emailAddress);

	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senKeyToElement(driver, passwordTextbox, password);

	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmpasswordTextbox);
		senKeyToElement(driver, confirmpasswordTextbox, confirmPassword);

	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, registersuccessMessage);
		return isElementDisplayed(driver, registersuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}
}
