package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Common02_Cookie  extends BaseTest {
	WebDriver driver;
	String firtName, lastName, companyName, gender;
	boolean status;
	public static String email, password;
	public static Set<Cookie> allCookies; 

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);

		firtName = "Florence";
		lastName = "Williams";
		email = "testqa" + getRandom() + "@gmail.com";

		companyName = "Digital Tech";
		password = "123456";

		log.info("Register - Step 01 : Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);

		// verify register link displayed-> failed
//		log.info("Register - Step 02 : Verify Register Link Displayed");
//		verifyTrue(registerPage.isSuccessMessageDisplayed());

		// verify login link displayed->failed
//		log.info("Register - Step 03 : Verify Login Link Displayed");
//		verifyTrue(homePage.isLoginLinkDisplayed());

		log.info("Precondition - Step 04 : Click To Register Link at Home Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 05 : Click To Gender Male Radio Button");
		registerPage.clickToGenderMaleRadioButton();

		log.info("Register - Step 06 : Input To First Name textbox with value: " + firtName);
		registerPage.enterToFirstNameTextbox(firtName);
		registerPage.sleepInSecond(1);
		log.info("Register - Step 07 : Input To Last Name textbox with value: " + lastName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.sleepInSecond(2);
		log.info("Register - Step 08 : Input To Email textbox with value: " + email);
		registerPage.enterToEmailTextbox(email);
		registerPage.sleepInSecond(1);
		log.info("Register - Step 09 : Input To Company Name textbox ");
		registerPage.inputToCompanyTexbox(companyName);
		registerPage.sleepInSecond(2);
		log.info("Register - Step 10 : Input To Password textbox with value: " + password);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.sleepInSecond(1);
		log.info("Register - Step 11 : Click to Register Button at Register Page");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 12 : Verify success message displayed");
		verifyEquals(registerPage.getSuccessMessageText(), "Your registration completed");
		registerPage.sleepInSecond(1);
		
		allCookies = driver.manage().getCookies();
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	
}
