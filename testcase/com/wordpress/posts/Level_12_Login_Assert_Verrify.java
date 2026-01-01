package com.wordpress.posts;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsWordpress.DashboardPageObject;
import pageObjectsWordpress.LoginPageObject;

public class Level_12_Login_Assert_Verrify extends BaseTest{
	WebDriver driver;
	// String projectLocation = System.getProperty("user.dir");
	LoginPageObject loginPage;
	DashboardPageObject dashboardPageObject;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver=getBrowserDriver(browserName, appUrl);
		//driver.get(appUrl);
		//loginPage = new LoginPageObject(driver);
	}

	//@Test
	public void Login_01_Valid_Email_Password() {
		loginPage.inputToUsernameTextbox("");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		dashboardPageObject = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPageObject.isDashboardHeaderTextDisplaed());
	}
	
	@Test
	public void Login_02_Assert() {
		System.out.println("02 Step 01 - Failed");
		Assert.assertTrue(false);
		System.out.println("02 Step 02 - Pass");
		Assert.assertTrue(true);
		System.out.println("02 Step 03 - Failed");
		Assert.assertTrue(true);
		System.out.println("02 Step 04 - Pass");
		Assert.assertTrue(false);
	}
	@Test
	public void Login_03_Verify() {
		System.out.println("03 Step 01 - Failed");
		verifyTrue(false);
		System.out.println("03 Step 02 - Pass");
		verifyTrue(true);
		System.out.println("03 Step 03 - Failed");
		verifyTrue(true);
		System.out.println("03 Step 04 - Pass");
		verifyTrue(false);
	}

	public int getRandom() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
