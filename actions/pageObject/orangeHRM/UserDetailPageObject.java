package pageObject.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserDetailPageObject  extends BasePage{
 WebDriver driver;

public UserDetailPageObject(WebDriver driver) {
	this.driver = driver;
}
}
