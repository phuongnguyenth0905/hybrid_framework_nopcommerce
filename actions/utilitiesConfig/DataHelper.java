package utilitiesConfig;

public class DataHelper {
	private static FakerConfig faker = new FakerConfig();

    public static DataHelper getData() {
        return new DataHelper();
    }

    public String getFirstName() {
        return faker.getFirstName();
    }

    public String getLastName() {
        return faker.getLastName();
    }

    public String getFullName() {
        return faker.getFullName();
    }

    public String getEmail() {
        return faker.getEmail();
    }

    public String getPassword() {
        return faker.getPassword();
    }

    public String getCompany() {
        return faker.getCompanyName();
    }

    public String getAddress() {
        return faker.getAddress();
    }

    public String getCity() {
        return faker.getCity();
    }
}
