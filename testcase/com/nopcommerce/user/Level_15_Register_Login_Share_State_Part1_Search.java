package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Level_15_Common01_Register_Login;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;

public class Level_15_Register_Login_Share_State_Part1_Search extends BaseTest {
	WebDriver driver;
	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		homePage=PageGeneratorManager.getHomePage(driver);

		log.info("Login - Step 01 : Open Login Page");
		loginPage = homePage.clickToLoginLink();
		loginPage.sleepInSecond(1);
		log.info("Login - Step 02 : Input to Email textbox with value : " + Level_15_Common01_Register_Login.email);
		loginPage.enterToEmailTextbox(Level_15_Common01_Register_Login.email);

		log.info("Login - Step 03 : Input to Password textbox with value : " + Level_15_Common01_Register_Login.password);
		loginPage.enterToPasswordTextbox(Level_15_Common01_Register_Login.password);

		log.info("Login - Step 04 : Click to Login button at Login Page");
		homePage = loginPage.clickToLoginButton();

	}

	@Test
	public void TC_01_Search_product_With_Name() {

//		log.info("Register - Step 13 : Click To Logout Link and navigate to home page");
//		homePage = registerPage.clickToLogoutLink();
//
//		registerPage.sleepInSecond(1);
	}

	@Test
	public void TC_02_Search_product_With_Category() {

	}

	@Test
	public void TC_03_Search_product_With_Sub_Category() {

	}

	@Test
	public void TC_04_Search_product_With_Price() {

	}

	@Test
	public void TC_05_Search_product_With_Manufacturer() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	

}