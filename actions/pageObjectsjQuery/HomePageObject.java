package pageObjectsjQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIsjQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);

	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void inputToHeaderTextboxByLabel(String labelName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, labelName);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, value, labelName);
		presskeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, Keys.ENTER, labelName);
	}

	public boolean areRowRecordDisplayed(String females, String countryName, String males, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELD, females, countryName, males, total);

		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELD, females, countryName, males, total);
	}

	public void clickActionIconByCountryName(String countryName, String actionName) {
		waitForElementClickable(driver, HomePageUI.ACTION_ICON_BY_NAME, countryName, actionName);
		clickToElement(driver, HomePageUI.ACTION_ICON_BY_NAME, countryName, actionName);

	}

	public void inputToTextboxByColumnNameAtRowNumber(String columName, String rowIndex, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_NAME_PRECEDING, columName);
		int coumnIndex = getElementNumber(driver, HomePageUI.HEADER_NAME_PRECEDING, columName) + 1;
		sendKeyToElement(driver, HomePageUI.TEXTBOX_AT_COLUMN_AND_ROW_INDEX,	value, rowIndex, String.valueOf(coumnIndex));
	}

	public boolean areFileNameLoadedSuccess(String[] fileNames) {
		boolean status=false;
		for(String fileName:fileNames) {
			if (isElementDisplayed(driver, HomePageUI.LOADED_FILE_NAME, fileName)) {
				status=true;
			} else {
				return status;
			}
		}
		return status;
	}

	public void clickToStartUploadButton() {
		List<WebElement> uploadButtons=getListWebElement(driver, HomePageUI.START_UPLOAD_BUTTON);
		for (WebElement uploadBtn : uploadButtons) {
			uploadBtn.click();
			sleepInSecond(2);
		}
		
	}

	public boolean areFileUploadedSuccess(String[] fileNames) {
		boolean status=false;
		for(String fileName:fileNames) {
			if (isElementDisplayed(driver, HomePageUI.UPLOAD_FILE_NAME, fileName)) {
				status=true;
			} else {
				return status;
			}
		}
		return status;
	}
}
