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

public class Level_06_Login_Page_Switch_Page extends BaseTest {
	WebDriver driver;
	String emailAddress;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInfoPageObject customerInfoPage;
	AboutUsPageObject aboutUsPage;
	NewsPageObject newsPage;
	ShoppingCartPageObject shoppingCartPage;
	SiteMapPageObject siteMapPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		// pageGenerator=PageGeneratorManager.getPageGenerator();
		emailAddress = "ezrah_bailey" + getRandom() + "@radiant-flow.org"; // ezrah.bailey@radiant-flow.org
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register_To_System() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox("Florence");
		registerPage.enterToLastNameTextbox("Williams");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		homePage = loginPage.clickToLoginButton();
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_Customer_info() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "Florence");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), "Williams");
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
	}

	@Test
	public void User_04_Switch_Page() {
		// Customer info -> Sitemap
		siteMapPage = customerInfoPage.clickToSiteMapLink(driver);
		// Sitemap -> News
		newsPage = siteMapPage.clickToNewsLink(driver);
		// News -> Shopping cart
		shoppingCartPage = newsPage.clickToShoppingcartLink(driver);
		// Shopping cart -> About us
		aboutUsPage = shoppingCartPage.clickToAboutUsLink(driver);
		// About us -> Home page
		homePage = aboutUsPage.clickToHomePage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
