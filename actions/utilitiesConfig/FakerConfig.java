package utilitiesConfig;

import java.util.Date;
import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerConfig {
	private Locale locale=new Locale("en");
	private Faker faker=new Faker(locale);
	public static FakerConfig getData() {
		return new FakerConfig();
	}
	public String getFirstName() {
		return faker.address().firstName();
	}
	public String getLastName() {
		return faker.address().lastName();
	}
	public String getCompanyName() {
		return faker.company().name();
	}
	public String getFullName() {
		return faker.name().fullName();
	}
	public String getAddress() {
		return faker.address().streetAddress();
	}
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	public String getCity() {
		return faker.address().city();
	}
	public String getCityName() {
		return faker.address().cityName();
	}
	public String getPassword() {
		return faker.internet().password();
	}
	public String getSSN() {
		return faker.idNumber().ssnValid();
	}
	public String getGender() {
		return faker.demographic().sex();
	}
	public String getNationality() {
		return faker.nation().nationality();

	}
	public Date getDateofBirth() {
		return faker.date().birthday();
		
	}
	public String getStreet() {
		return faker.address().streetAddress();

	}
	public String getState() {
		return faker.address().state();
		
	}
	public String getCountry() {
		return faker.address().country();
		
	}
	public String getZipCode() {
		return faker.address().zipCode();

		
	}
	
}
