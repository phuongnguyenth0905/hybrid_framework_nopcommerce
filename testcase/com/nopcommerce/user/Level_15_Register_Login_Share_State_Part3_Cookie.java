package com.nopcommerce.user;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common02_Cookie;
import com.nopcommerce.common.Level_15_Common01_Register_Login;

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

public class Level_15_Register_Login_Share_State_Part3_Cookie extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		

		log.info("Login - Step 01 : Open Login Page");
		homePage=PageGeneratorManager.getHomePage(driver);
		for (Cookie cookie :Common02_Cookie.allCookies) {
			driver.manage().addCookie(cookie);

		}
		homePage.refreshPage(driver);
		homePage.sleepInSecond(10);
		log.info("Login - Step 05 : Verigy My account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_01_Sort_Name_Ascending() {

//		log.info("Register - Step 13 : Click To Logout Link and navigate to home page");
//		homePage = registerPage.clickToLogoutLink();
//
//		registerPage.sleepInSecond(1);
	}

	@Test
	public void TC_02_Sort_Name_Descending() {

	}

	@Test
	public void TC_03_Sort_Price_Ascending() {

	}

	@Test
	public void TC_04_TC_03_Sort_Price_Descending() {

	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	} 

	HomePageObject homePage;
	
	LoginPageObject loginPage;
	

}