package pageUIsWordpress;

public class LoginPageUI {
	public static final String USERNAME_EMAIL_TEXTBOX = "//input[@id='usernameOrEmail']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
	public static final String CONTINUE_BUTTON = "//button[text()='Continue']";
	public static final String LOGIN_BUTTON = "//button[text()='Log In']";
	public static final String EMPTY_EMAIL_ERROR_MSG = "//span[text()='Please enter a username or email address.']";
	public static final String INVALID_EMAIL_ERROR_MSG = "//div[@class='form-input-validation is-error has-icon' and contains(string(),'User does not exist. Would you like to create a new account?')]";
	public static final String EMPTY_PASSWORD_ERROR_MSG = "//p[@class='login-form__validation-error-wrapper']";
	public static final String INVALID_PASSWORD_ERROR_MSG = "//p[@class='login-form__validation-error-wrapper']";
}
