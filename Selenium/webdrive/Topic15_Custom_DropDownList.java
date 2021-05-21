package webdrive;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

// Selenium khong ho tro, phai tu viet ham

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic15_Custom_DropDownList {
	WebDriver driver;
// khai bao jsexcutor de viet ham verify cho Angular
	JavascriptExecutor jsExcutor;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);
		jsExcutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
// select item
		selectItemInDropdown("//span[@id='number-button']", "//li[@class='ui-menu-item']/div", "5");
//verify item
		Assert.assertTrue(driver
				.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='5']"))
				.isDisplayed());
		selectItemInDropdown("//span[@id='number-button']", "//li[@class='ui-menu-item']/div", "19");
		Assert.assertTrue(driver
				.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='19']"))
				.isDisplayed());

	}

	@Test
	public void TC_02_Angular() {
		driver.get("https://bit.ly/2UV2vYi");
		selectItemInDropdown("//ejs-dropdownlist[@id='games')]//span[contains@class,'e-search-icon')]",
				"//ul[@id='games_options']/li", "Basketball");
//verify bang ham tu viet
		Assert.assertEquals(getHiddenText("select[id='games_hidden'] option"), "Basketball");

	}

	@Test
//freelancer trang upwork,xem trang web dung cong nghe go wappalyzer
	public void TC_03_React() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		selectItemInDropdown("//i[@class='dropdown icon']", "//span[@class='text']", "Justen Kitsune");
//verify 
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@role='listbox']/div[@class='text' and text()='Justen Kitsune']"))
						.isDisplayed());

	}

	@Test
//freelancer trang upwork,xem trang web dung cong nghe go wappalyzer
	public void TC_04_Edittable() {
		driver.get("https://indrimuska.github.io/jquery-editable-select/");
		sendkeyToEditDropdown("//div[@id='default-place']/input", "Ford");
		Assert.assertEquals(getHiddenText("#default-place li.es-visible"), "Ford");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

//ham de sendkey cho tC4
	public void sendkeyToEditDropdown(String locator, String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);
		sleepInSecond(1);
		driver.findElement(By.xpath(locator)).sendKeys(Keys.TAB);
		sleepInSecond(1);
//PHAN MULTIL SELECK la phan nang cao, xem them 1h26p topic 15
	}

// do angular dropdown bi an nen ca viet ham get ra
	public String getHiddenText(String cssLocator) {
		return (String) jsExcutor.executeScript("return document.querySelector(\"" + cssLocator + "\").text");

	}

// ham xu ly ham nay dung di dung lai nhieu lan, chi can truyen vao gia tri
	public void selectItemInDropdown(String parentLocator, String itemLocator, String expectedItem) {
// 1.click vao 1 the bat ki de xo ra het cac item trong dropdown
		driver.findElement(By.xpath(parentLocator)).click();
		sleepInSecond(1);

//2. cho cho tat ca cac item co trong HTML DOM( ko can visible)
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemLocator)));
//3. lay het tat ca cac item nay dua vao 1 list element
		List<WebElement> allItems = driver.findElements(By.xpath(itemLocator));
//4. duyet qua tung item
		for (WebElement item : allItems) {
//5. moi lan duyet qua kiem tra xem text cua item do co bang voi item minh can click hay khong
			String actualItem = item.getText();
//neu nhu ma bang thi thoat khoi khong duyet nua
//neu nhu khong bang thi duyet tiep cho den het tat ca item
			if (actualItem.equals(expectedItem)) {
//truoc khi click thi scroll den element
				jsExcutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(2);
//wait cho element click able
				explicitWait.until(ExpectedConditions.elementToBeClickable(item));
				item.click();
				sleepInSecond(2);
				break;
			}
		}

	}

// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai exception, chu ko stop cac testcase sau
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
