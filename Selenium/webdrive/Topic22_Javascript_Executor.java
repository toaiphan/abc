package webdrive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

//javascript excutor la nhung ma javasciprt vao de lam gi do voi browser hoac element
// dung cho trick : co nghia la nhung truong hop thong thuong ko lam dc
// no khong giong voi nguoi dung binh thuong=> de bo sot issue
// dung nhieu nhat la click va scrollto element
public class Topic22_Javascript_Executor {
	// khai bao Javascript executor
	JavascriptExecutor jsExecutor;
	WebDriver driver;
	WebElement element;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		// khoi tao
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// @Test
	public void TC_01_Click_Hidden_Element() {
		// mno trang
		driver.get("");

		// lay ra webelement cua homeand bath

		// click vao element bang javascript executor

		// kiem tra da hien thi

	}

	@Test
	public void TC_02_Live_Guru() {

		// mo trarg
		navigateToUrlByJS("http://live.demoguru99.com");

		// get domain
		String liveGuruDomain = (String) executeForBrowser("return document.domain;");
		Assert.assertEquals(liveGuruDomain, "live.demoguru99.com");

		// get URL
		String liveGuruURL = (String) executeForBrowser("return document.URL;");
		Assert.assertEquals(liveGuruURL, "http://live.demoguru99.com/");

		// click mobile
		// dung de highlight len cho de nhin
		highlightElement("//a[text()='Mobile']");
		clickToElementByJS("//a[text()='Mobile']");

		// add to cart
		clickToElementByJS("//a[text()='Samsung Galaxy']//parent::h2//following-sibling::div[@class='actions']/button");
		// verify bang 2 cach
		// cach1
		String liveGuruInnerValue = getInnerText();
		Assert.assertTrue(liveGuruInnerValue.contains("Samsung Galaxy was added to your shopping cart."));
		// cach 2
		Assert.assertTrue(areExpectedTextInInnerText("Samsung Galaxy was added to your shopping cart."));

		// click vao customer service

		clickToElementByJS("//a[text()='Customer Service']");

		// verify title
		String customerServiceTitle = (String) executeForBrowser("return document.title;");
		Assert.assertEquals(customerServiceTitle, "Customer Service");

		// scroll den new letter
		scrollToElement(".//*[@id='newsletter']");

		// verify chua text

		Assert.assertTrue(
				areExpectedTextInInnerText(" Praesent ipsum libero, auctor ac, tempus nec, tempor nec, justo."));

		// mo trarg
		navigateToUrlByJS("http://demo.guru99.com/v4/");
		// get domain
		String demoGuruDomain = (String) executeForBrowser("return document.domain;");
		Assert.assertEquals(demoGuruDomain, "demo.guru99.com");

	}

// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai exception, chu ko stop cac testcase sau
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//cac ham javascript excutor thuong dung

// de lay url,title.. lien quan den webbrowser
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

// khong the get text bang selenium thi dung ham nay
	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {

		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(String locator) {
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		// jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value +
		// "')", getElement(driver, locator));
	}

// su dug vi du nhu date birth , bo atribute type="date" de tro thanh binh thuong
	public void removeAttributeInDOM(String locator, String attributeRemove) {
		element = driver.findElement(By.xpath(locator));

		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		// explicitWait = new WebDriverWait(driver, timeout);
		jsExecutor = (JavascriptExecutor) driver;

		// ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		// @Override
		// public Boolean apply(WebDriver driver) {
		try {
			return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
		} catch (Exception e) {
			return true;
		}
	}
	// };

	// ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	// @Override
	// public Boolean apply(WebDriver driver) {
	// return jsExecutor.executeScript("return
	// document.readyState").toString().equals("complete");
	// }
	// };

//		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
//	}

//	public String getElementValidationMessage(WebDriver driver, String locator) {
//		jsExecutor = (JavascriptExecutor) driver;
//		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
//	}

//	public boolean isImageLoaded(WebDriver driver, String locator) {
//		jsExecutor = (JavascriptExecutor) driver;
	// boolean status = (boolean) jsExecutor.executeScript(
	// "return arguments[0].complete && typeof arguments[0].naturalWidth !=
	// \"undefined\" && arguments[0].naturalWidth > 0",
//				getElement(driver, locator));
//		if (status) {
//			return true;
//		} else {
	// return false;
//		}
//	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
