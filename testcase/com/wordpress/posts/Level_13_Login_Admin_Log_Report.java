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

public class Level_13_Login_Admin_Log_Report extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPageObject;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver=getBrowserDriver(browserName, appUrl);
		log.info("------------------ Log Report ------------------");
		driver.get(appUrl);

	}

	@Test
	public void Login_01_Valid_Email_Password() {
		log.info("Login - Step 01: Login Wordpress ");
		loginPage = new LoginPageObject(driver);
		log.info("Login - Step 02: Input to Username ");
		loginPage.inputToUsernameTextbox("");
		
		log.info("Login -Step 03: Click to Login Button after input Username");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		
		log.info("Login -Step 04: Input to password");
		loginPage.inputToPasswordTextbox("");
		
		log.info("Login -Step 05: Click to Login Button after input Password");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		
		log.info("Login -Step 06: Login Success Dashboard Page");
		dashboardPageObject = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPageObject.isDashboardHeaderTextDisplaed());
	}
	
	@Test
	public void Login_02_Element_Displayed() {
		log.info("Login Test case 02 - Step 01: Open Option Button ");
		dashboardPageObject.clickToScreenOptionButton();
		loginPage.sleepInSecond(2);

		log.info("Login Test case 02 - Step 02: Verify Activity Checkbox Displayed");
		Assert.assertTrue(dashboardPageObject.isActivityCheckboxDisplayed());
		
		log.info("Login Test case 02 - Step 03: click To Screen Option Button ");
		dashboardPageObject.clickToScreenOptionButton();
		loginPage.sleepInSecond(2);
	}
	@Test
	public void Login_03_Element_Undisplayed_In_DOM() {
		log.info("Login Test case 03 - Step 01: click To Screen Option Button ");
		dashboardPageObject.clickToScreenOptionButton();
		
		log.info("Login Test case 03 - Step 02: Verify Activity Checkbox Displayed");
		loginPage.sleepInSecond(2);
		Assert.assertTrue(dashboardPageObject.isActivityCheckboxDisplayed());
	}
	@Test
	public void Login_04_Element_Undisplayed_Without_DOM() {
		log.info("Login Test case 04 - Step 01: Post Search Textbox Undisplayed");
		boolean postSearch=dashboardPageObject.isPostSearchTextboxUndisplayed();
		
		log.info("Login Test case 04 - Step 02: Verify Post Search Textbox Undisplayed ");
		Assert.assertFalse(postSearch);
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
