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

public class Level_08_DataTable extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPageByNumber("5");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageActiveByNumber("5"));
		homePage.openPageByNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));
		homePage.openPageByNumber("15");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		homePage.openPageByNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageActiveByNumber("20"));
		homePage.openPageByNumber("23");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageActiveByNumber("23"));
	}

	// @Test
	public void Table_02_Search() {
		// homePage.refreshPage(driver);
		// Search by Females
		homePage.inputToHeaderTextboxByLabel("Females", "384187");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.areRowRecordDisplayed("384187", "Afghanistan", "407124", "791312"));
		homePage.refreshPage(driver);
		// Search by Country
		homePage.inputToHeaderTextboxByLabel("Country", "Afghanistan");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.areRowRecordDisplayed("384187", "Afghanistan", "407124", "791312"));
		homePage.refreshPage(driver);
		// Search by Males
		homePage.inputToHeaderTextboxByLabel("Males", "407124");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.areRowRecordDisplayed("384187", "Afghanistan", "407124", "791312"));
		homePage.refreshPage(driver);
		// Search by Total
		homePage.inputToHeaderTextboxByLabel("Total", "791312");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.areRowRecordDisplayed("384187", "Afghanistan", "407124", "791312"));
		homePage.refreshPage(driver);
	}

	// @Test
	public void Table_03_Edit_Delete() {
		homePage.clickActionIconByCountryName("Albania", "edit");
		homePage.sleepInSecond(2);
		homePage.refreshPage(driver);

		homePage.clickActionIconByCountryName("Armenia", "edit");
		homePage.sleepInSecond(2);
		homePage.refreshPage(driver);

		homePage.clickActionIconByCountryName("Aruba", "remove");
		homePage.sleepInSecond(2);
		homePage.refreshPage(driver);

		homePage.clickActionIconByCountryName("Afghanistan", "remove");
		homePage.sleepInSecond(2);
		homePage.refreshPage(driver);

	}

	@Test
	public void Table_04_Edit_Delete() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.inputToTextboxByColumnNameAtRowNumber("Contact Person", "3", "Test 123");
		homePage.sleepInSecond(2);
		
		//homePage.inputToTextboxByColumnNameAtRowNumber("Contact Person", "4", "Test Contact qa");
		//homePage.sleepInSecond(2);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Company", "2", "auto 574");
		homePage.sleepInSecond(2);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Order Placed", "1", "order 666");
		homePage.sleepInSecond(2);
	}

	 @Test
	public void User_05_Dynamic_Page_Locator() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		//homePage.inputDataToTable("","","","","","");
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private HomePageObject homePage;
}
