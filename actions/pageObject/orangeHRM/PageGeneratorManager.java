package pageObject.orangeHRM;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static DashboardPageObject  geDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	public static EmployeeDetailPageObject  getEmployeeDetailPage(WebDriver driver) {
		return new EmployeeDetailPageObject(driver);
	}
	public static UserDetailPageObject getUserDetailPage(WebDriver driver) {
		return new UserDetailPageObject(driver);
	}
	public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPageObject(driver);
	}

}
