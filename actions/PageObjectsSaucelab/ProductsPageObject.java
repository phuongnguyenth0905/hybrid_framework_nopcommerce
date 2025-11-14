package PageObjectsSaucelab;

import org.openqa.selenium.WebDriver;

import PageUIsSaucelab.ProductPageUI;
import commons.BasePage;

public class ProductsPageObject extends BasePage{
	WebDriver driver;

	public ProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean areProductNameSortedByAscending() {
		waitForListElementVisible(driver, ProductPageUI.ALL_PRODUCT_NAME);
		return isStringSortedAsc(driver, ProductPageUI.ALL_PRODUCT_NAME);
	}

	public boolean areProductNameSortedByDescending() {
		waitForListElementVisible(driver, ProductPageUI.ALL_PRODUCT_NAME);
		return isStringSortedDesc(driver, ProductPageUI.ALL_PRODUCT_NAME);
	}

	public void selectItemInProductSortDropdown(String itemValue) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN_LIST);
		selectItemInDropdown(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN_LIST, itemValue);
	}

	public boolean areProductPriceSortedByAscending() {
		waitForListElementVisible(driver, ProductPageUI.ALL_PRODUCT_PRICE);
		return isFloatSortedAsc(driver, ProductPageUI.ALL_PRODUCT_PRICE);
	}

	public boolean areProductPriceSortedByDescending() {
		waitForListElementVisible(driver, ProductPageUI.ALL_PRODUCT_PRICE);
		return isFloatSortedDesc(driver, ProductPageUI.ALL_PRODUCT_PRICE);
	}
}