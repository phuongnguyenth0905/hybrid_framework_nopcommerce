package commons;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.GlobalConstants;
import pageObjects.AboutUsPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewsPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ShoppingCartPageObject;
import pageObjects.SiteMapPageObject;
import pageUIs.BasePageUI;
import pageUIsjQuery.HomePageUI;

public class BasePage {
	JavascriptExecutor jsExecutor;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();

	}

	public void senkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void swichToWindownByID(WebDriver driver, String parentID) {
		Set<String> allWindowns = driver.getWindowHandles();
		for (String runWindow : allWindowns) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void swichToWindownByTitle(WebDriver driver, String title) {
		Set<String> allWindowns = driver.getWindowHandles();
		for (String runWindow : allWindowns) {
			driver.switchTo().window(runWindow);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowns = driver.getWindowHandles();
		for (String runWindow : allWindowns) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);

	}

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(By.xpath(locator));
	}

	public String getDynamicLocator(String locator, String... values) {
		return String.format(locator, (Object[]) values);

	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		getWebElement(driver, getDynamicLocator(locator, values)).click();
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}

	private void clickToElement(WebElement element) {
		element.click();
	}

	public void senKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}

	public void senKeyToElement(WebDriver driver, String locator, String value, String... values) {
		WebElement element = getWebElement(driver, getDynamicLocator(locator, values));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(valueItem);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem, String... values) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(locator, values)));
		select.selectByVisibleText(valueItem);
	}

	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		clickToElement(driver, parentLocator);
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
		List<WebElement> allItems = getListWebElement(driver, childItemLocator);
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				clickToElement(item);
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText().trim();
	}

	public String getElementText(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).getText().trim();
	}

	public String getElementAttributeValue(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getAttribute("value");
	}

	public String getElementAttributeByName(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}

	public int getElementNumber(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}

	public int getElementNumber(WebDriver driver, String locator, String... values) {
		return getListWebElement(driver, getDynamicLocator(locator, values)).size();
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		boolean status = false;
		try {
			status = getWebElement(driver, locator).isDisplayed();
			return status;
		} catch (Exception e) {
			return status;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver, String locator) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}

	public void presskeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}

	public void presskeyToElement(WebDriver driver, String locator, Keys key, String... values) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicLocator(locator, values)), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("windows.location='" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(3);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, values)));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void senkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value','" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeINDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}

			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");

			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
		} catch (TimeoutException e) {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
		}
		
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
		} catch (TimeoutException e) {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
		}
		//
	}

	public void waitForListElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = System.getProperty("user.dir") + getDirectorySlash("uploadFiles");
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		senKeyToElement(driver, HomePageUI.UPLOAD_FILE_TYPE, fullFileName);
	}

	public String getDirectorySlash(String foldeName) {
		String separator = System.getProperty("file.separator");
		return separator + foldeName + separator;
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		System.out.println("Start time" + new Date().toString());
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locator);
		overrideImplicitTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time" + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/ displayed");
			System.out.println("End time" + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator, String... values) {
		System.out.println("Start time" + new Date().toString());
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, getDynamicLocator(locator, values));
		overrideImplicitTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time" + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/ displayed");
			System.out.println("End time" + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}

	public void overrideImplicitTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	/* Common Page Object Click switch page */
	public ShoppingCartPageObject clickToShoppingcartLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SHOPPING_CART_PAGE_LINK);
		clickToElement(driver, BasePageUI.SHOPPING_CART_PAGE_LINK);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}

	public HomePageObject clickToHomePage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.HOME_PAGE_LINK);
		clickToElement(driver, BasePageUI.HOME_PAGE_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public SiteMapPageObject clickToSiteMapLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SITE_MAP_PAGE_LINK);
		clickToElement(driver, BasePageUI.SITE_MAP_PAGE_LINK);
		return PageGeneratorManager.getSiteMapPage(driver);
	}

	public AboutUsPageObject clickToAboutUsLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ABOUT_US_PAGE_LINK);
		clickToElement(driver, BasePageUI.ABOUT_US_PAGE_LINK);
		return PageGeneratorManager.getAboutUsPage(driver);
	}

	public NewsPageObject clickToNewsLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.NEWS_PAGE_LINK);
		clickToElement(driver, BasePageUI.NEWS_PAGE_LINK);
		return PageGeneratorManager.getNewsPage(driver);
	}/* Dynamic locator 1- page it (5-20 page) */

	public BasePage openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.FOOTER_PAGE_LINK_NAME, pageName);
		waitForElementClickable(driver, BasePageUI.FOOTER_PAGE_LINK_NAME, pageName);
		if (pageName.equals("Shopping cart")) {
			return PageGeneratorManager.getShoppingCartPage(driver);
		} else if (pageName.equals("Sitemap")) {
			return PageGeneratorManager.getSiteMapPage(driver);
		} else if (pageName.equals("About us")) {
			return PageGeneratorManager.getAboutUsPage(driver);
		} else if (pageName.equals("News")) {
			return PageGeneratorManager.getNewsPage(driver);
		} else {
			throw new RuntimeException("Please input the correct page name!");
		}
	}

	/* NHieu page- vai chuc toi vai tram page */
	public void openFooterPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.FOOTER_PAGE_LINK_NAME, pageName);
		clickToElement(driver, BasePageUI.FOOTER_PAGE_LINK_NAME, pageName);
	}

	public void clickToRadioButtonByID(WebDriver driver, String radioButtonID) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
		clickToElement(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
	}

	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		senKeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}

	public void clickToButtonByName(WebDriver driver, String buttonID) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_NAME, buttonID);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_NAME, buttonID);
	}

	public String getErrorMessageAtMandantoryFieldByID(WebDriver driver, String fieldID) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, fieldID);
		return getElementText(driver, BasePageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, fieldID);
	}
}
