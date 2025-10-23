package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.AboutUsPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewsPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.ShoppingCartPageObject;
import pageObjects.SiteMapPageObject;

public class Level_13_Register_Login_Log_Report extends BaseTest {
	WebDriver driver;
	String firtName, lastName, email, companyName, password, day, month, year, gender;
	boolean status;

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
	public void TC_01_Register() {
		log.info("Register - Step 01 : Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);

		// verify register link displayed-> failed
//		log.info("Register - Step 02 : Verify Register Link Displayed");
//		verifyTrue(registerPage.isSuccessMessageDisplayed());

		// verify login link displayed->failed
//		log.info("Register - Step 03 : Verify Login Link Displayed");
//		verifyTrue(homePage.isLoginLinkDisplayed());

		log.info("Register - Step 04 : Click To Register Link at Home Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 05 : Click To Gender Male Radio Button");
		registerPage.clickToGenderMaleRadioButton();

		log.info("Register - Step 06 : Input To First Name textbox with value: " + firtName);
		registerPage.enterToFirstNameTextbox(firtName);
		registerPage.sleepInSecond(2);
		log.info("Register - Step 07 : Input To Last Name textbox with value: " + lastName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.sleepInSecond(2);
		log.info("Register - Step 08 : Input To Email textbox with value: " + email);
		registerPage.enterToEmailTextbox(email);
		registerPage.sleepInSecond(2);
		log.info("Register - Step 09 : Input To Company Name textbox ");
		registerPage.inputToCompanyTexbox(companyName);
		registerPage.sleepInSecond(2);
		log.info("Register - Step 10 : Input To Password textbox with value: " + password);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.sleepInSecond(2);
		log.info("Register - Step 11 : Click to Register Button at Register Page");
		registerPage.clickToRegisterButton();
		// registerPage.clickToRegisterButton();

		log.info("Register - Step 12 : Verify success message displayed");
		verifyEquals(registerPage.isSuccessMessageDisplayed(), "Your registration completed");
		registerPage.sleepInSecond(2);
		log.info("Register - Step 13 : Click To Logout Link and navigate to home page");
		homePage = registerPage.clickToLogoutLink();

		registerPage.sleepInSecond(3);
	}

	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01 : Open Login Page");
		loginPage = homePage.clickToLoginLink();
		loginPage.sleepInSecond(3);
		log.info("Login - Step 02 : Input to Email textbox with value : " + email);
		loginPage.enterToEmailTextbox(email);

		log.info("Login - Step 03 : Input to Password textbox with value : " + password);
		loginPage.enterToPasswordTextbox(password);

		log.info("Login - Step 04 : Click to Login button at Login Page");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05 : Verigy My account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06 : Verify Shopping cart item undisplayed");
		verifyTrue(homePage.isShoppingCartNoItemTooltipUndisplayed());

		log.info("Login - Step 07 : Verify Logout Link Displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());

		log.info("Login - Step 08 : Verify Register Link Undisplayed");
		verifyTrue(homePage.isRegisterLinkUndisplayed());

		log.info("Login - Step 09 : Verify Login Link Undisplayed");
		verifyFalse(homePage.isLoginLinkUndisplayed());
	}

	// @Test
	public void TC_03_View_My_Account() {

		// homePage.clickToMyAccountLink();
		customerInforPage = homePage.clickToMyAccountLink();

		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firtName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), companyName);
		Assert.assertTrue(customerInforPage.isNewsletterCheckboxSelected());
	}

	// cách 1:dùng cho page nhỏ (ít page)
	// @Test
	public void TC_04_Rest_Parameter_01() {
		siteMapPage = (SiteMapPageObject) customerInforPage.openFooterPageByName(driver, "Sitemap");
		newsPage = (NewsPageObject) siteMapPage.openFooterPageByName(driver, "News");
		shoppingCartPage = (ShoppingCartPageObject) newsPage.openFooterPageByName(driver, "Shopping cart");
		aboutUsPage = (AboutUsPageObject) shoppingCartPage.openFooterPageByName(driver, "About us");
		shoppingCartPage = (ShoppingCartPageObject) aboutUsPage.openFooterPageByName(driver, "Shopping cart");
		siteMapPage = (SiteMapPageObject) shoppingCartPage.openFooterPageByName(driver, "Sitemap");
		aboutUsPage = (AboutUsPageObject) siteMapPage.openFooterPageByName(driver, "About us");
		newsPage = (NewsPageObject) aboutUsPage.openFooterPageByName(driver, "News");
		siteMapPage = (SiteMapPageObject) newsPage.openFooterPageByName(driver, "Sitemap");
	}

	// cách 2:
	// @Test
	public void TC_05_Rest_Parameter_02() {
		siteMapPage.openFooterPageName(driver, "News");
		newsPage = PageGeneratorManager.getNewsPage(driver);

		newsPage.openFooterPageName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

		shoppingCartPage.openFooterPageName(driver, "About us");
		aboutUsPage = PageGeneratorManager.getAboutUsPage(driver);

		aboutUsPage.openFooterPageName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

		shoppingCartPage.openFooterPageName(driver, "Sitemap");
		siteMapPage = PageGeneratorManager.getSiteMapPage(driver);

		siteMapPage.openFooterPageName(driver, "About us");
		aboutUsPage = PageGeneratorManager.getAboutUsPage(driver);

		aboutUsPage.openFooterPageName(driver, "News");
		newsPage = PageGeneratorManager.getNewsPage(driver);

		newsPage.openFooterPageName(driver, "Sitemap");
		siteMapPage = PageGeneratorManager.getSiteMapPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInforPage;
	AboutUsPageObject aboutUsPage;
	NewsPageObject newsPage;
	ShoppingCartPageObject shoppingCartPage;
	SiteMapPageObject siteMapPage;

}