package com.saucelab.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectsSaucelab.LoginPageObject;
import PageObjectsSaucelab.PageGeneratorManager;
import PageObjectsSaucelab.ProductsPageObject;
import commons.BaseTest;


public class Level_19_SAUCELAB_Sort_ASC_DESC extends BaseTest {
	WebDriver driver;
	String userName, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);

		userName = "standard_user";
		password = "secret_sauce";
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToUsernameTextbox(userName);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		productPage = PageGeneratorManager.getProductsPage(driver);
	}


	@Test
	public void TC_01_Sort_Product_Name() {
		
		log.info("TC_01_Sort_Product_Name: Name (A to Z)");
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(5);
		verifyTrue(productPage.areProductNameSortedByAscending());

		log.info("TC_01_Sort_Product_Name: Name (Z to A)");
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(5);
		verifyTrue(productPage.areProductNameSortedByDescending());

	}

	@Test
	public void TC_02_Sort_Product_Price() {
		log.info("TC_02_Sort_Product_Price: Price (low to high)");
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(5);
		verifyTrue(productPage.areProductPriceSortedByAscending());

		log.info("TC_02_Sort_Product_Price: Price (high to low)");
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(5);
		verifyTrue(productPage.areProductPriceSortedByDescending());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	ProductsPageObject productPage;
	LoginPageObject loginPage;
}