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

public class Level_11_Login_Element_Undisplayed extends BaseTest{
	WebDriver driver;
	// String projectLocation = System.getProperty("user.dir");
	LoginPageObject loginPage;
	DashboardPageObject dashboardPageObject;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver=getBrowserDriver(browserName, appUrl);
		driver.get(appUrl);
		loginPage = new LoginPageObject(driver);
	}

	@Test
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
	public void Login_02_Element_Displayed() {
		dashboardPageObject.clickToScreenOptionButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(dashboardPageObject.isActivityCheckboxDisplayed());
		dashboardPageObject.clickToScreenOptionButton();
		loginPage.sleepInSecond(2);
	}
	@Test
	public void Login_03_Element_Undisplayed_In_DOM() {
		dashboardPageObject.clickToScreenOptionButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(dashboardPageObject.isActivityCheckboxDisplayed());
	}
	@Test
	public void Login_04_Element_Undisplayed_Without_DOM() {
		boolean postSearch=dashboardPageObject.isPostSearchTextboxUndisplayed();
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
