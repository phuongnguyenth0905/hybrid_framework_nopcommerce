package pageObjectsWordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsWordpress.DashboardPageUI;

public class DashboardPageObject extends BasePage{
	WebDriver driver;
	public DashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public boolean isDashboardHeaderTextDisplaed() {
		waitForElementVisible(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
	}
	public void clickToScreenOptionButton() {
		waitForElementVisible(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
		clickToElement(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
	}
	public boolean isActivityCheckboxDisplayed() {
		waitForElementVisible(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
		return isElementDisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}
	public boolean isActivityCheckboxUnDisplayed() {
		waitForElementInvisible(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
		return isElementDisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}
	public boolean isPostSearchTextboxUndisplayed() {
		return isControlDisplayed(driver, DashboardPageUI.POST_SEARCH_TEXTBOX);
		}
	
}
