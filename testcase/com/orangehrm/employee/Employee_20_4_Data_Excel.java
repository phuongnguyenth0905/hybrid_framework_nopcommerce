package com.orangehrm.employee;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.orangeHRM.DashboardPageObject;
import pageObject.orangeHRM.EmployeeDetailPageObject;
import pageObject.orangeHRM.EmployeeListPageObject;
import pageObject.orangeHRM.LoginPageObject;
import pageObject.orangeHRM.PageGeneratorManager;
import pageObject.orangeHRM.UserDetailPageObject;
import utilitiesConfig.ExcelHelper;


public class Employee_20_4_Data_Excel extends BaseTest {
	WebDriver driver;
	List<Map<String, String>> excelData;
	
	String firstName, lastName, employeeID;
	String editFirstName, editLastName, editSSN, editGender, editMaritalStatus, editNationality, editDateOfBirth;
	String payGrade, salaryComponent, payFrequency, currency, amountSalary, comments, accountNumber, accountType,
			routingNumber, amountDetails;
	String street1, street2, city, state, zipCode, country, homePhone, mobilePhone, workPhone, workEmail, otheEmail;
	String joinedDate, jobTitle, jobCategory, subUnit, location, employmentStatus;
	String relationshipChild, documentPassport, numberImmigration, issuedDate, expiryDate, eligibleStatus, issuedBy, eligibleReviewDate;
	String reportingMethod, companyName, comment, nameSupervisors;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		excelData = ExcelHelper.readExcel("testdata/DataTestExcel.xlsx");
		
		firstName = excelData.get(0).get("firstName");
		lastName =excelData.get(0).get("lastName");
		editFirstName = excelData.get(0).get("editFirstName");
		editLastName = excelData.get(0).get("editLastName");
		editSSN = excelData.get(0).get("editSSN");
		editGender = "Male";
		editMaritalStatus = "Single";
		editNationality = "Vietnamese";
		editDateOfBirth = "1995-02-06";

		payGrade = "Grade 5";
		salaryComponent = editFirstName + " - Anual Basic Payment";
		payFrequency = "Monthly on first pay of month.";
		currency = "United States Dollar";
		amountSalary = "20000";
		comments = "Salary per month";
		comment="Check Qualifications comment pa";
		accountNumber = "49876" + getRandom();
		accountType = "Savings";
		routingNumber = "4789" + getRandom();
		amountDetails = "12300";
//
		street1 = excelData.get(0).get("street1");
		street2 =excelData.get(0).get("street2");
		city = excelData.get(0).get("city");
		state = excelData.get(0).get("state");
		zipCode =excelData.get(0).get("zipCode");
		country = excelData.get(0).get("country");
		homePhone = "+1 8659683972";
		mobilePhone = "+1 8659683972";
		workPhone = "+1 4587516792";
		workEmail = excelData.get(0).get("workEmail");
		otheEmail = excelData.get(0).get("otheEmail");
//Job Details
		joinedDate="2024-12-06";
		jobTitle="Chief Executive Officer";
		jobCategory="Professionals";
		subUnit="Finance";
		location="Texas R&D";
		employmentStatus="Full-Time Permanent";
		
		relationshipChild="Child";
		documentPassport="Passport";
		numberImmigration="N645654"+getRandom();
		issuedDate="2025-06-08" ;
		expiryDate="2025-21-11"; 
		eligibleStatus="By text by check text auto";
		issuedBy="Turkey";
		eligibleReviewDate="2025-05-11";
		
		reportingMethod="Direct";
		companyName="AAA company";
		nameSupervisors="James Butler";
		
		log.info("Pre-condition - Step 01: Enter to Username textbox");
		loginPage.enterToUsernameTextbox("Admin");

		log.info("Pre-condition - Step 02: Enter to Password textbox");
		loginPage.enterToPasswordTextbox("admin123");

		log.info("Pre-condition - Step 03: Click to Login button");
		dashboardPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Employee_01_Add_Employee() {
		log.info("Employee - Step 01: Open Home Page");
		dashboardPage.openMenuPageByName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Employee - Step 02: Click button at Employee Information Page");
		employeeDetailPage = employeeListPage.clickToAddButton();
		
		employeeDetailPage.sleepInSecond(2);
		log.info("Employee - Step 03: Input First Name : " + firstName);
		employeeDetailPage.enterToFirstNameTextboxAtAddEmployeeForm(firstName);

		log.info("Employee - Step 04: Input Last Name : " + lastName);
		employeeDetailPage.enterToLastNameTextboxAtAddEmployeeForm(lastName);

		employeeDetailPage.sleepInSecond(2);
		log.info("Employee - Step 05: Get Employee ID" + employeeID);
		employeeID = employeeDetailPage.getTextboxValueDynamicByLabelAtForm(driver, "Employee Id");

		log.info("Employee - Step 06: Click save button");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Add Employee", "Save");
		employeeDetailPage.sleepInSecond(2);
		log.info("Employee - Step 07: Verify displayed full name: " + firstName + " " + lastName);
		verifyTrue(employeeDetailPage.isFullnameDisplayedAtHeader(firstName + " " + lastName));
		employeeDetailPage.sleepInSecond(2);
		log.info("Employee - Step 08: Verify displayed First name: " + firstName);
		verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalDetailsForm(), firstName);
		employeeDetailPage.sleepInSecond(2);
		log.info("Employee - Step 09: Verify displayed Last name: " + lastName);
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalDetailsForm(), lastName);
		employeeDetailPage.sleepInSecond(2);
		log.info("Employee - Step 10: Verify displayed Employee ID: " + employeeID);
		verifyEquals(employeeDetailPage.getTextboxValueDynamicByLabelAtForm(driver, "Employee Id"), employeeID);
	}

	@Test
	public void Employee_02_Edit_Employee_Person() {
		log.info("Edit Employee [Perional] - Step 02: Enter new info to 'First Name' textbox: " + firstName);
		employeeDetailPage.enterToFirstNameTextboxAtPersonalDetailForm(editFirstName);

		log.info("Edit Employee [Perional] - Step 03: Enter new info to 'Last Name' textbox: " + lastName);
		employeeDetailPage.enterToLasttNameTextboxAtPersonalDetailForm(editLastName);

		log.info("Edit Employee [Perional] - Step 04: Enter new info to 'SSN Number' textbox: " + editSSN);
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "License Number", editSSN);

		log.info("Edit Employee [Perional] - Step 05: Click to 'Gender' radio with 'Male': " + editGender);
		employeeDetailPage.clickToGenderRadioAtPersonalDetailForm(editGender);

		log.info("Edit Employee [Perional] - Step 06: Select to 'Marital status' dropdown with 'Single': "
				+ editMaritalStatus);
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Marital Status", "Single");

		log.info("Edit Employee [Perional] - Step 07: Select to 'Nationality' dropdown with : "
				+ editNationality);
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Nationality", editNationality);

		log.info("Edit Employee [Perional] - Step 08: Enter new info to 'Date of Birth' textbox: " + editDateOfBirth);
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Date of Birth", editDateOfBirth);
		employeeDetailPage.sleepInSecond(3);
		log.info("Edit Employee [Perional] - Step 09:Click to 'Save' button at 'Personal Details' form ");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Personal Details", "Save");

		log.info(
				"Edit Employee [Perional] - Step 10: Verify sucess message displayed with value 'Successfully Updated'");
		verifyEquals(employeeDetailPage.getSuccessfullyMessageAtPersonalDetailForm(), "Successfully Updated");

		log.info("Edit Employee [Perional] - Step 11: Verify 'First Name' textbox edited successfully: "
				+ editFirstName);
		verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalDetailForm(), editFirstName);

		log.info("Edit Employee [Perional] - Step 12: Verify 'Last Name' textbox edited successfully: " + editLastName);
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalDetailForm(), editLastName);

		log.info("Edit Employee [Perional] - Step 13: Verify 'SSN Number' textbox edited successfully: " + editSSN);
		verifyEquals(employeeDetailPage.getTextboxValueDynamicByLabelAtForm(driver, "License Number"), editSSN);

		log.info("Edit Employee [Perional] - Step 14: Verify 'Gender' radio edited successfully: " + editGender);
		verifyFalse(employeeDetailPage.isGenderRadioButtonSelectedAtPersonalDetailForm(editGender));

		log.info("Edit Employee [Perional] - Step 15: Verify 'Marital status' dropdown edited successfully: "
				+ editMaritalStatus);
		verifyEquals(employeeDetailPage.getSelectedValueDynamicInDropdownByLabelAtForm(driver, "Marital Status"),
				editMaritalStatus);

		log.info("Edit Employee [Perional] - Step 16: Verify 'Nationality' dropdown edited successfully: "
				+ editNationality);
		verifyEquals(employeeDetailPage.getSelectedValueDynamicInDropdownByLabelAtForm(driver, "Nationality"),
				editNationality);

		log.info("Edit Employee [Perional] - Step 17: Verify 'Date of Birth' textbox edited successfully: "
				+ editDateOfBirth);
		//verifyEquals(employeeDetailPage.getTextboxValueDynamicByLabelAtForm(driver, "Date of Birth"), "1995-02-06"); // "Monday,
																														// 06-Feb-1995");
		employeeDetailPage.sleepInSecond(3);
	}

	@Test
	public void Employee_03_Add_Employee_By_Contact_Details() {
		log.info("Employee [Contact_Details] - Steps 01: Open 'Contact Details' tab");
		employeeDetailPage.openSidebarTabByName("Contact Details");

		log.info("Employee [Contact_Details] - Steps 02: Input Address 'Street 1' ");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Street 1", street1);

		log.info("Employee [Contact_Details] - Steps 03: Input Address 'Street 2' ");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Street 2", street2);

		log.info("Employee [Contact_Details] - Steps 04: Input 'City' ");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "City", city);

		log.info("Employee [Contact_Details] - Steps 05: Input 'State/Province' ");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "State/Province", state);

		log.info("Employee [Contact_Details] - Steps 06: Input Zip code ");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Zip/Postal Code", zipCode);

		log.info("Employee [Contact_Details] - Steps 07: Input 'Country '");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Country", country);

		log.info("Employee [Contact_Details] - Steps 08: Input 'Home phone' ");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Home", homePhone);

		log.info("Employee [Contact_Details] - Steps 09: Input 'Mobile phone '");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Mobile", mobilePhone);

		log.info("Employee [Contact_Details] - Steps 10: Input 'Work phone' ");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Work", workPhone);

		log.info("Employee [Contact_Details] - Steps 11: Input 'Work Email '");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Work Email", workEmail);
        employeeDetailPage.sleepInSecond(2);
		log.info("Employee [Contact_Details] - Steps 12: Input 'Other Email' ");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Other Email", otheEmail);
		employeeDetailPage.sleepInSecond(2);
		log.info("Employee [Contact_Details] - Steps 13: Click to 'Save' button at 'Contact Details' form ");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Contact Details", "Save");
		employeeDetailPage.sleepInSecond(2);
		
		log.info("Employee [Contact_Details] - Steps 14: Verify sucess message displayed with value 'Successfully Updated'");
		verifyEquals(employeeDetailPage.getSuccessfullyMessageAtPersonalDetailForm(), "Successfully Updated");
	}

	@Test
	public void Employee_04_Edit_Employee_By_Job() {
		log.info("Edit Employee [Salary] - Step 01: Open 'Job' tab");
		employeeDetailPage.openSidebarTabByName("Job");
		
		log.info("Employee [Job Details] - Step 01 Select 'Joined Date' dropdown :");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Joined Date", joinedDate);
		
		log.info("Employee [Job Details] - Step 02 : Select 'Job Title' dropdown");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Job Title", jobTitle);
		
		log.info("Employee [Job Details] - Step 03 : Select 'Job Category' dropdown");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Job Category", jobCategory);
		
		log.info("Employee [Job Details] - Step 04 : Select 'Sub Unit' dropdown");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Sub Unit", subUnit);
		
		log.info("Employee [Job Details] - Step 05 : Select 'Location' dropdown");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Location", location);
		
		log.info("Employee [Job Details] - Step 06 : Select 'Employment Status' dropdown");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Employment Status", employmentStatus);
		
		log.info("Employee [Job Details] - Steps 13: Click to 'Save' button at 'Job Details' form ");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Job Details", "Save");
	}

	@Test
	public void Employee_05_Edit_Employee_By_Salary() {
		log.info("Edit Employee [Salary] - Step 01: Open 'Salary' tab");
		employeeDetailPage.openSidebarTabByName("Salary");

		log.info("Edit Employee [Salary] - Step 02: Click to Add button at 'Assigned Salary Components form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Assigned Salary Components", "Add");

//		log.info("Edit Employee [Salary] - Step 03: Select to 'Pay Grade' dropdown with value: " + payGrade);
//		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Pay Grade", payGrade);

		log.info(
				"Edit Employee [Salary] - Step 04: Enter to 'Salary Component' textbox with value: " + salaryComponent);
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Salary Component", salaryComponent);

		log.info("Edit Employee [Salary] - Step 05: Select to 'Pay Frequeny' dropdown with value: " + payFrequency);
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Pay Frequency", payFrequency);

		log.info("Edit Employee [Salary] - Step 06: Select to 'Currency' dropdown with value: " + currency);
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Currency", currency);

		log.info("Edit Employee [Salary] - Step 07: Enter to 'Amount' textbox with value: " + amountSalary + "$");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Amount", amountSalary);
		employeeDetailPage.sleepInSecond(2);
		log.info("Edit Employee [Salary] - Step 08: Enter to 'Comments' textbox with value: " + comments);
		employeeDetailPage.enterToCommentstextareaAtSalaryForm(driver, "Comments", comment);

//		log.info("Edit Employee [Salary] - Step 09: Turn ON 'Include Direct Deposit Details' toggle");
//		employeeDetailPage.clickToToggleSwitchByLabelAtForm(driver, "Include Direct Deposit Details", true);
//
//		log.info("Edit Employee [Salary] - Step 10: Enter to 'Account Number' textbox with value: " + accountNumber);
//		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Account Number", accountNumber);
//		log.info("Edit Employee [Salary] - Step 11: Select to 'Account Type' dropdown with value: " + accountType);
//		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Account Type", accountType);
//
//		log.info("Edit Employee [Salary] - Step 12: Enter to 'Routing Number' textbox with value: " + routingNumber);
//		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Routing Number", routingNumber);
//
//		log.info("Edit Employee [Salary] - Step 13: Enter to 'Amount' textbox with value: " + amountDetails + "$");
//		employeeDetailPage.enterToAmountTextboxByLabelAtForm(amountDetails);

		log.info("Edit Employee [Salary] - Step 14: Click to 'Save' button at 'Add Salary Component' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Add Salary Component", "Save");
		employeeDetailPage.sleepInSecond(1);
		// verify at Table
		verifyTrue(employeeDetailPage.isInformationDisplayAtColumnAndRowNumber(driver, "Salary Component",
				"Salary Component", "1", salaryComponent));
	}
	
	@Test
	public void Employee_06_Ad_Emergency_Contacts() {
		log.info("Edit Employee [ Emergency Contact] - Step 01: Open 'Job' tab");
		employeeDetailPage.openSidebarTabByName("Emergency Contacts");
		
		log.info("Employee [ Emergency Contact]  - Step 02: Click button at Employee Information Page");
		employeeDetailPage = employeeListPage.clickToAddButton();
		
		log.info("Employee [ Emergency Contact] - Step 03 : Enter 'Name' of Emergency Contact");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Name", firstName+" "+lastName);
		
		log.info("Employee [ Emergency Contact] - Step 04 : Enter 'Relationship' of Emergency Contact");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Relationship", relationshipChild);
		
		log.info("Employee [ Emergency Contact] - Step 05 : Enter 'Home Telephone' of Emergency Contact");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Home Telephone", homePhone);
		
		log.info("Employee [ Emergency Contact] - Step 06 : Enter 'Mobile' of Emergency Contact");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Mobile", mobilePhone);
		
		log.info("Employee [ Emergency Contact] - Step 07 : Enter 'Work Telephone' of Emergency Contact");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Work Telephone", workPhone);
		
		
		log.info("Employee [ Emergency Contact] - Step 06 : Click to 'Save' button at 'Save Emergency Contact' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Save Emergency Contact", "Save");
	}
	
	@Test
	public void Employee_07_Ad_Emergency_Contacts() {
		log.info("Edit Employee [Dependents] - Step 01: Open 'Dependents' tab");
		employeeDetailPage.openSidebarTabByName("Dependents");
		
		log.info("Edit Employee [Dependents] - Step 02: Click to Add button at 'Assigned Salary Components form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Assigned Dependents", "Add");
		
		log.info("Edit Employee [ Dependents] - Step 03: Enter to 'Name ' of Dependents");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Name", firstName+" "+lastName);
		
		log.info("Edit Employee [ Dependents] - Step 04:  Enter 'Relationship' of Dependents ");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Relationship", relationshipChild);
		
		log.info("Edit Employee [ Dependents] - Step 05: Enter info to 'Date of Birth' textbox of Dependents");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Date of Birth", editDateOfBirth);
		
		log.info("Edit Employee [ Dependents] - Step 06 : Click to 'Save' button at 'Add Dependent' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Add Dependent", "Save");
	}
	
	@Test
	public void Employee_08_Add_Immigration() {
		log.info("Edit Employee [Immigration] - Step 01: Open 'Immigration' tab");
		employeeDetailPage.openSidebarTabByName("Immigration");
		log.info("Edit Employee [Immigration] - Step 02: Click to Add button at 'Add Immigration' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Assigned Immigration Records", "Add");
		
		log.info("Employee [Immigration] - Step 03 : Choose radion button 'Passport/Visa'  of Immigration");
		employeeDetailPage.clickToGenderRadioAtPersonalDetailForm(documentPassport);
		
		log.info("Employee [Immigration] - Step 04 : enter 'Number' textbox");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Number", numberImmigration);
		
		log.info("Employee [Immigration] - Step 05 : select 'Issued Date' dropdownlist");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Issued Date", issuedDate);
		
		log.info("Employee [Immigration] - Step 06 : select 'Expiry Date' dropdownlist");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Expiry Date", expiryDate);
		
		log.info("Employee [Immigration] - Step 07 : Enter 'Eligible Status' textbox");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Eligible Status", eligibleStatus);
		
		log.info("Employee [Immigration] - Step 08 : select 'Issued By' dropdownlist");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Issued By", issuedBy);
		
		log.info("Employee [Immigration] - Step 09 : Select 'Eligible Review Date' dropdownlist");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Eligible Review Date", eligibleReviewDate);
		
		log.info("Employee [Immigration] - Step 10 : Enter 'Comments' textbox");
		employeeDetailPage.enterToCommentstextareaAtSalaryForm(driver, "Comments", comments);
		
		log.info("Employee [Immigration] - Step 11 : Click to 'Save' button at 'Save Emergency Contact' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Add Immigration", "Save");
	}
	
	@Test
	public void Employee_09_Ad_Report_to() {
		log.info("Edit Employee [Report-to] - Step 01: Open 'Report-to' tab");
		employeeDetailPage.openSidebarTabByName("Report-to");
		
		log.info("Edit Employee [Report-to] - Step 02: Click to Add button at 'Assigned Supervisors' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Assigned Supervisors", "Add");
		
		log.info("Edit Employee [Report-to] - Step 03: Search Add Supervisor 'Name' textbox");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Name",nameSupervisors);
		
		log.info("Edit Employee [Report-to] - Step 04: Select 'Reporting Method' dropdown");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Reporting Method", reportingMethod);
		
		log.info("Employee [ Emergency Contact] - Step 05 : Click to 'Save' button at 'Report to' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Report to", "Save");
	}
	
	@Test
	public void Employee_10_Ad_Qualifications() {
		log.info("Edit Employee [Qualifications] - Step 01: Open 'Qualifications' tab");
		employeeDetailPage.openSidebarTabByName("Qualifications");
		
		log.info("Edit Employee [Qualifications] - Step 02: Click to Add button at 'Assigned Salary Components form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Work Experience", "Add");
		
		log.info("Edit Employee [Qualifications] - Step 03: enter 'Company' textbox");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Company", companyName);
		
		log.info("Edit Employee [Qualifications] - Step 04: enter 'Job Title' textbox");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Job Title", jobTitle);
		
		log.info("Edit Employee [Qualifications] - Step 05: select 'From' dropdownlist");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "From", "2025-03-09");
		
		log.info("Edit Employee [Qualifications] - Step 06: select 'To' dropdownlist");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "To", "2025-11-12");
		
		log.info("Edit Employee [Qualifications] - Step 07: enter to 'Comment' textbox");
		employeeDetailPage.enterToCommentstextareaAtSalaryForm(driver, "Comment", comment);
		
		log.info("Employee [ Emergency Contact] - Step 08 : Click to 'Save' button at 'Save Emergency Contact' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Qualifications", "Save");
	}
	
	@Test
	public void Employee_11_Ad_Memberships() {
		log.info("Edit Employee [Memberships] - Step 01: Open 'Memberships' tab");
		employeeDetailPage.openSidebarTabByName("Memberships");
		
		log.info("Edit Employee [Memberships] - Step 02: Click to Add button at 'Assigned Memberships' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Assigned Memberships", "Add");
		
		log.info("Edit Employee [Memberships] - Step 03: Select to 'Membership' dropdownlist");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Membership", "ACCA");
		
		log.info("Edit Employee [Memberships] - Step 04: Select to 'Subscription Paid By' dropdownlist");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Subscription Paid By", "Company");
		
		log.info("Edit Employee [Memberships] - Step 05: input 'Subscription Amount' textbox");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Subscription Amount", amountSalary);
		
		log.info("Edit Employee [Memberships] - Step 06: Select to 'Currency' dropdownlist");
		employeeDetailPage.selectItemDynamicInDropdownByLabelAtForm(driver, "Currency", "Iceland Krona");
		
		log.info("Edit Employee [Memberships] - Step 07: Select to 'Subscription Commence Date' dropdownlist");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Subscription Commence Date", eligibleReviewDate);
		
		log.info("Edit Employee [Memberships] - Step 08: Select to 'Subscription Renewal Date' dropdownlist");
		employeeDetailPage.enterToTextboxDynamicByLabelAtForm(driver, "Subscription Renewal Date", expiryDate);
		
		log.info("Employee [Memberships] - Step 06 : Click to 'Save' button at 'Add Membership' form");
		employeeDetailPage.clickToButotnByNameAtFormHeader(driver, "Add Membership", "Save");
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	EmployeeDetailPageObject employeeDetailPage;
	EmployeeListPageObject employeeListPage;
	UserDetailPageObject userDetailPage;

}