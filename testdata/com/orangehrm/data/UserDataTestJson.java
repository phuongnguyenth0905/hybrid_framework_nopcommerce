package com.orangehrm.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDataTestJson {
	public static UserDataTestJson get(String filename) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(filename), UserDataTestJson.class);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// ======================= BASIC INFO =========================
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("editFirstName")
    private String editFirstName;

    @JsonProperty("editLastName")
    private String editLastName;

    @JsonProperty("editSSN")
    private String editSSN;

    @JsonProperty("editGender")
    private String editGender;

    @JsonProperty("editMaritalStatus")
    private String editMaritalStatus;

    @JsonProperty("editNationality")
    private String editNationality;

    @JsonProperty("editDateOfBirth")
    private String editDateOfBirth;


    // ======================= SALARY =========================
    @JsonProperty("payGrade")
    private String payGrade;

    @JsonProperty("salaryComponent")
    private String salaryComponent;

    @JsonProperty("payFrequency")
    private String payFrequency;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("amountSalary")
    private String amountSalary;

    @JsonProperty("comments")
    private String comments;

    @JsonProperty("comment")
    private String comment;


    // ======================= BANK DETAILS =========================
    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("accountType")
    private String accountType;

    @JsonProperty("routingNumber")
    private String routingNumber;

    @JsonProperty("amountDetails")
    private String amountDetails;


    // ======================= CONTACT INFO =========================
    @JsonProperty("street1")
    private String street1;

    @JsonProperty("street2")
    private String street2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("homePhone")
    private String homePhone;

    @JsonProperty("mobilePhone")
    private String mobilePhone;

    @JsonProperty("workPhone")
    private String workPhone;

    @JsonProperty("workEmail")
    private String workEmail;

    @JsonProperty("otherEmail")
    private String otherEmail;


    // ======================= JOB DETAILS =========================
    @JsonProperty("joinedDate")
    private String joinedDate;

    @JsonProperty("jobTitle")
    private String jobTitle;

    @JsonProperty("jobCategory")
    private String jobCategory;

    @JsonProperty("subUnit")
    private String subUnit;

    @JsonProperty("location")
    private String location;

    @JsonProperty("employmentStatus")
    private String employmentStatus;


    // ======================= IMMIGRATION =========================
    @JsonProperty("relationshipChild")
    private String relationshipChild;

    @JsonProperty("documentPassport")
    private String documentPassport;

    @JsonProperty("numberImmigration")
    private String numberImmigration;

    @JsonProperty("issuedDate")
    private String issuedDate;

    @JsonProperty("expiryDate")
    private String expiryDate;

    @JsonProperty("eligibleStatus")
    private String eligibleStatus;

    @JsonProperty("issuedBy")
    private String issuedBy;

    @JsonProperty("eligibleReviewDate")
    private String eligibleReviewDate;


    // ======================= REPORTING =========================
    @JsonProperty("reportingMethod")
    private String reportingMethod;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("nameSupervisors")
    private String nameSupervisors;


    // ======================= GETTERS =========================
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEditFirstName() { return editFirstName; }
    public String getEditLastName() { return editLastName; }
    public String getEditSSN() { return editSSN; }
    public String getEditGender() { return editGender; }
    public String getEditMaritalStatus() { return editMaritalStatus; }
    public String getEditNationality() { return editNationality; }
    public String getEditDateOfBirth() { return editDateOfBirth; }

    public String getPayGrade() { return payGrade; }
    public String getSalaryComponent() { return salaryComponent; }
    public String getPayFrequency() { return payFrequency; }
    public String getCurrency() { return currency; }
    public String getAmountSalary() { return amountSalary; }
    public String getComments() { return comments; }
    public String getComment() { return comment; }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public String getRoutingNumber() { return routingNumber; }
    public String getAmountDetails() { return amountDetails; }

    public String getStreet1() { return street1; }
    public String getStreet2() { return street2; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public String getCountry() { return country; }
    public String getHomePhone() { return homePhone; }
    public String getMobilePhone() { return mobilePhone; }
    public String getWorkPhone() { return workPhone; }
    public String getWorkEmail() { return workEmail; }
    public String getOtherEmail() { return otherEmail; }

    public String getJoinedDate() { return joinedDate; }
    public String getJobTitle() { return jobTitle; }
    public String getJobCategory() { return jobCategory; }
    public String getSubUnit() { return subUnit; }
    public String getLocation() { return location; }
    public String getEmploymentStatus() { return employmentStatus; }

    public String getRelationshipChild() { return relationshipChild; }
    public String getDocumentPassport() { return documentPassport; }
    public String getNumberImmigration() { return numberImmigration; }
    public String getIssuedDate() { return issuedDate; }
    public String getExpiryDate() { return expiryDate; }
    public String getEligibleStatus() { return eligibleStatus; }
    public String getIssuedBy() { return issuedBy; }
    public String getEligibleReviewDate() { return eligibleReviewDate; }

    public String getReportingMethod() { return reportingMethod; }
    public String getCompanyName() { return companyName; }
    public String getNameSupervisors() { return nameSupervisors; }
}
