package pageObject.orangeHRM;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.orangeHRM.EmployeeDetailPageUI;
import pageUIs.orangeHRM.orangeHRMBasePageUI;

public class EmployeeDetailPageObject extends BasePage {
	WebDriver driver;

	public EmployeeDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextboxAtAddEmployeeForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_EMPLOYEE_FORM);
		sendKeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_EMPLOYEE_FORM, firstName);
	}

	public void enterToLastNameTextboxAtAddEmployeeForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_EMPLOYEE_FORM);
		sendKeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_EMPLOYEE_FORM, lastName);
	}

	public boolean isFullnameDisplayedAtHeader(String fullName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM, fullName);
		return isElementDisplayed(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM, fullName);
	}

	public String getFirstNameValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttributeByName(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM,
				"value");
	}

	public String getLastNameValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttributeValue(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
	}

	/**Edit_Employee_Person**/

	public void enterToFirstNameTextboxAtPersonalDetailForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendKeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, firstName);
	}

	public void enterToLasttNameTextboxAtPersonalDetailForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendKeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, lastName);
	}
	//xoaa
	public void enterToAmountTextboxByLabelAtForm(String amountDetails) {
	    waitForElementVisible(driver, orangeHRMBasePageUI.AMOUNT_TEXTBOX_BY_LABEL_AT_FORM, amountDetails);
	    sendKeyToElement(driver, orangeHRMBasePageUI.AMOUNT_TEXTBOX_BY_LABEL_AT_FORM, amountDetails);
	   
	}

	public void clickToGenderRadioAtPersonalDetailForm(String genderValue) {
		waitForElementClickable(driver, EmployeeDetailPageUI.GENDER_RADIO_AT_PERSON_DETAIL_FORM, genderValue);
		checkToCheckboxOrRadio(driver, EmployeeDetailPageUI.GENDER_RADIO_AT_PERSON_DETAIL_FORM, genderValue);
	}

	public String getSuccessfullyMessageAtPersonalDetailForm() {
		 waitForElementPresence(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_AT_PERSON_DETAIL_FORM);
		waitForElementVisible(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_AT_PERSON_DETAIL_FORM);
		return getElementText(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_AT_PERSON_DETAIL_FORM);
	}

	public String getFirstNameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttributeByName(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM,
				"value");
	}

	public String getLastNameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttributeByName(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM,
				"value");
	}
	public boolean isGenderRadioButtonSelectedAtPersonalDetailForm(String genderValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.GENDER_RADIO_AT_PERSON_DETAIL_FORM, genderValue);
		return isElementSelected(driver, EmployeeDetailPageUI.GENDER_RADIO_AT_PERSON_DETAIL_FORM, genderValue);
	}

	public void openSidebarTabByName(String sideBarName) {
		waitForElementClickable(driver, EmployeeDetailPageUI.SIDEBAR_TAB_BY_NAME, sideBarName);
		clickToElement(driver, EmployeeDetailPageUI.SIDEBAR_TAB_BY_NAME, sideBarName);
	}

	public void enterToCommentstextareaAtSalaryForm(WebDriver driver, String labelName, String valueText) {
		waitForElementVisible(driver, EmployeeDetailPageUI.COMMENTS_TEXTBOX_AT_SALARY_FORM, labelName);
		sendKeyToElement(driver, EmployeeDetailPageUI.COMMENTS_TEXTBOX_AT_SALARY_FORM,  valueText, labelName);
		
	}
	public boolean isVerifyInformationDisplayAtColumnAndRowNumber(WebDriver driver, String columnName, String rowIndex, String expectedValue) {
		int columnNameIndex=countElementSize(driver, orangeHRMBasePageUI.TABLE_ORANGEHRM_COLUMN_NAME_SIBLING, columnName)+1;
		String actualValue=getElementText(driver, orangeHRMBasePageUI.TABLE_ORANGEHRM_COLUMN_NAME_SIBLING, rowIndex,String.valueOf(columnNameIndex));
		return actualValue.equals(expectedValue);
		
//		// Lấy index của cột
//		waitForElementVisible(driver, orangeHRMBasePageUI.TABLE_ORANGEHRM_COLUMN_NAME_SIBLING, columnName);
//	    int columnIndex = countElementSize(driver, orangeHRMBasePageUI.TABLE_ORANGEHRM_COLUMN_NAME_SIBLING, columnName) + 1;
//
//	    // Kiểm tra xem row đầu tiên có rỗng không
//	    String firstRowLocator = String.format("(//div[@role='rowgroup']//div[@role='row'])[2]//div[contains(@class,'oxd-table-cell')][2]");
//	    if (!isElementDisplayed(driver, firstRowLocator)) {
//	        rowIndex = String.valueOf(Integer.parseInt(rowIndex) + 1);
//	    }
//waitForElementVisible(driver, orangeHRMBasePageUI.CELL_ORANGEHRM_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX,
//	        rowIndex);
//	    String actualValue = getElementText(driver,
//	        orangeHRMBasePageUI.CELL_ORANGEHRM_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX,
//	        rowIndex, String.valueOf(columnIndex));
//
//	   // System.out.printf("[DEBUG] Column: %s | Row: %s | Actual: %s | Expected: %s%n", columnName, rowIndex, actualValue, expectedValue);
//
//	    return actualValue.trim().equalsIgnoreCase(expectedValue.trim());
	}
}
