package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Level_17_Register_Login_Pattern_Object extends BaseTest {
	WebDriver driver;
	String firtName, lastName, email, companyName, password, day, month, year, gender;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);

		firtName = "Florence";
		lastName = "Williams";
		email = "testqa" + getRandom() + "@gmail.com";

		companyName = "Digital Tech";
		password = "123456";
		day = "11";
		month = "September";
		year = "1989";

	}

	@Test
	public void TC_01_Validate_At_Register_Form() {
		log.info("Register - Step 01 : Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Register - Step 02 : Click To Register Link at Home Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 03: Click to Register Button ");
		registerPage.clickToButtonByName(driver, "Register");
		registerPage.sleepInSecond(2);
		log.info("Register - Step 04: Verify Error message displayed at First name textbox. ");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "FirstName"), "First name is required.");

		log.info("Register - Step 05: Verify Error message displayed at Last name textbox. ");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "LastName"), "Last name is required.");

		log.info("Register - Step 06: Verify Error message displayed at Email textbox. ");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "Email"), "Email is required.");

		log.info("Register - Step 07: Verify Error message displayed at Password textbox. ");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "ConfirmPassword"),
				"Password is required.");

		log.info("Register - Step 08: Verify Error message displayed at Confirm password textbox. ");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "ConfirmPassword"),
				"Password is required.");
	}

	@Test
	public void TC_02_Register() {
		log.info("Register - Step 01 : Refresh to Register Page");
		registerPage.refreshPage(driver);

		log.info("Register - Step 02 : Click To Gender Male Radio Button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");

		log.info("Register - Step 03 : Input To First Name textbox with value: " + firtName);
		registerPage.inputToTextboxByID(driver, "FirstName", firtName);

		log.info("Register - Step 04 : Input To Last Name textbox with value: " + lastName);
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register - Step 05 : Input To Email textbox with value: " + email);
		registerPage.inputToTextboxByID(driver, "Email", email);

		log.info("Register - Step 06 : Input To Company Name textbox ");
		registerPage.inputToTextboxByID(driver, "Company", companyName);

		log.info("Register - Step 07 : Input To Password textbox with value: " + password);
		registerPage.inputToTextboxByID(driver, "Password", password);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register - Step 08 : Click to Register Button at Register Page");
		registerPage.clickToButtonByName(driver, "Register");

		log.info("Register - Step 09 : Verify success message displayed");
		verifyEquals(registerPage.getSuccessMessageText(), "Your registration completed");

		log.info("Register - Step 10 : Click To Logout Link and navigate to home page");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_03_Login() {
		log.info("Login - Step 01 : Open Login Page");
		loginPage = homePage.clickToLoginLink();
		loginPage.sleepInSecond(1);

		log.info("Login - Step 02 : Input to Email textbox with value : " + email);
		loginPage.inputToTextboxByID(driver, "Email", email);

		log.info("Login - Step 03 : Input to Password textbox with value : " + password);
		loginPage.inputToTextboxByID(driver, "Password", password);

		log.info("Login - Step 04 : Click to Login button at Login Page");
		loginPage.clickToButtonByName(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Login - Step 05 : Verigy My account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06 : Verify Shopping cart item undisplayed");
		verifyTrue(homePage.isShoppingCartNoItemTooltipUndisplayed());

		log.info("Login - Step 07 : Verify Logout Link Displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());

		log.info("Login - Step 08 : Verify Register Link Undisplayed");
		verifyTrue(homePage.isRegisterLinkUndisplayed());

		log.info("Login - Step 09 : Verify Login Link Undisplayed");
		verifyTrue(homePage.isLoginLinkUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;

}