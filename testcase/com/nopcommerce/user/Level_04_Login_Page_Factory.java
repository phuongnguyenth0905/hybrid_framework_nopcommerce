package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;


public class Level_04_Login_Page_Factory extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	String emailAddress;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		emailAddress = "ezrah_bailey" + getRandom() + "@radiant-flow.org"; // ezrah.bailey@radiant-flow.org
		homePage=new HomePageObject(driver);
	}

	@Test
	public void User_01_Register_To_System() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("Florence");
		registerPage.enterToLastNameTextbox("Williams");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void User_02_Login_To_System() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
