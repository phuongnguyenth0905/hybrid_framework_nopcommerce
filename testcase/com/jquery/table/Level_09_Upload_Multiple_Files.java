package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsjQuery.HomePageObject;
import pageObjectsjQuery.PageGeneratorManager;

public class Level_09_Upload_Multiple_Files extends BaseTest {
	WebDriver driver;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	 @Test
	public void Upload_01_One_File_Per_Time() {
		String[] fileNames= {"images (1).jfif"};
		homePage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(homePage.areFileNameLoadedSuccess(fileNames));
		
		homePage.clickToStartUploadButton();
		Assert.assertTrue(homePage.areFileUploadedSuccess(fileNames));
	}

	 @Test
	public void Upload_02_Multipe_File_Per_Time() {
		homePage.refreshPage(driver);
		String[] fileNames= {"images (1).jfif","images (2).jfif","images (3).jfif","images (4).jfif"};
		homePage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(homePage.areFileNameLoadedSuccess(fileNames));
		
		homePage.clickToStartUploadButton();
		Assert.assertTrue(homePage.areFileUploadedSuccess(fileNames));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private HomePageObject homePage;
}
