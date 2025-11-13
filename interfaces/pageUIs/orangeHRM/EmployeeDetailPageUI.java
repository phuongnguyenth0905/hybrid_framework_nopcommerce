package pageUIs.orangeHRM;

public class EmployeeDetailPageUI {
	/***Add Employee**/
public static final String FIRSTNAME_TEXTBOX_AT_EMPLOYEE_FORM="//input[@name='firstName']";
public static final String LASTNAME_TEXTBOX_AT_EMPLOYEE_FORM="//input[@name='lastName']";

/***Personal Details**/
public static final String FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM="//div[@class='orangehrm-edit-employee-name']";
public static final String FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM="//input[@name='firstName']";
public static final String LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM="//input[@name='lastName']";
public static final String GENDER_RADIO_AT_PERSON_DETAIL_FORM="//label[normalize-space()='%s']";
public static final String SUCCESS_MESSAGE_AT_PERSON_DETAIL_FORM="//p[text()='Success']/following-sibling::p";
public static final String SIDEBAR_TAB_BY_NAME ="//div[@class='orangehrm-tabs']//a[text()='%s']";

/***Salary Form**/
//public static final String SALARY_COMPONENT_AT_SALARY_FORM="//label[normalize-space()='Salary Component']/ancestor::div[contains(@class,'oxd-input-group')]//input";
public static final String PAY_GRADE_DROPDOWN_AT_SALARY_FORM="";
public static final String PAY_FREQUENCY_DROPDOWN_AT_SALARY_FORM="";
public static final String CURENCY_DROPDOWN_AT_SALARY_FORM="";
//public static final String AMOUNT_TEXTBOX_AT_SALARY_FORM="//label[normalize-space()='Amount']/ancestor::div[contains(@class,'oxd-input-group')]//input";
public static final String COMMENTS_TEXTBOX_AT_SALARY_FORM="//label[contains(normalize-space(),'%s')]/ancestor::div//textarea";

}
