package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	//PageGeneratorManager pageGenerator;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		//pageGenerator=PageGeneratorManager.getPageGenerator();
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}
	
	public boolean isLoginLinkDisplayed() {
		//waitToElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGIN_LINK);
	}
	public boolean isShoppingCartNoItemTooltipUndisplayed() {
		waitForElementInvisible(driver, HomePageUI.SHOPPING_CART_NO_ITEM_TOOLTIP);
		return isElementUndisplayed(driver, HomePageUI.SHOPPING_CART_NO_ITEM_TOOLTIP);
	}
	public boolean isRegisterLinkUndisplayed() {
		waitForElementInvisible(driver, HomePageUI.REGISTER_LINK);
		return isElementUndisplayed(driver, HomePageUI.REGISTER_LINK);
	}
	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	}
	public boolean isLoginLinkUndisplayed() {
		waitForElementInvisible(driver, HomePageUI.LOGIN_LINK);
		return isElementUndisplayed(driver, HomePageUI.LOGIN_LINK);
	}
}
