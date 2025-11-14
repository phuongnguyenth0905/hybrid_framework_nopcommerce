package PageObjectsSaucelab;

import org.openqa.selenium.WebDriver;

import pageObject.orangeHRM.DashboardPageObject;

public class PageGeneratorManager {

	public static ProductsPageObject getProductsPage(WebDriver driver) {
		return new ProductsPageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	

}
