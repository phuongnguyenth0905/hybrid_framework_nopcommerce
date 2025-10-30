package pageUIs;

public class BasePageUI {
	public static final String HOME_PAGE_LINK = "//img[@alt='nopCommerce demo store']";
	public static final String ABOUT_US_PAGE_LINK = "//a[text()='About us']";
	public static final String NEWS_PAGE_LINK = "//div[@class='footer']//a[text()='News']";
	public static final String SHOPPING_CART_PAGE_LINK = "//a[text()='Shopping cart']";
	public static final String SITE_MAP_PAGE_LINK = "//div[@class='footer']//a[text()='Sitemap']";
	
	public static final String FOOTER_PAGE_LINK_NAME = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_NAME = "//button[text()='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID = "//span[@id='%s-error']";
}
