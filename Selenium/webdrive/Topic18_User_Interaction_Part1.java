package webdrive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic18_User_Interaction_Part1 {
	WebDriver driver;
	Actions action;
	WebElement element;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		action = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// @Test
	public void TC_01_() {
		driver.get("https://www.myntra.com/");
		element = driver.findElement(By.xpath("//a[@data-group='kids']"));

		// hover to Element , can co perform de thuc thi
		action.moveToElement(element).perform();

		sleepInSecond(5);
		// khi chay test se bi chiem chuot=> khong dung chuot khi chay test
		// click vao home bath
		driver.findElement(By.xpath("//a[text()='Home & Bath']")).click();
		// verify da vao dc trang home bath ( tu lam dc)
	}

	@Test
	// click and hold (46'47 topic 18)
	public void TC_02_Click_And_Hold() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		String [] selectedTextExpected = {"1","2","3","4","5","6","7","8"};

		// khai bao list element, moi e element la 1 so(1 o so)
		List<WebElement> allItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));

		// click and hold vao o so 1, move den o so 8, tha chuot ( ham release de tha
		// chuot)
		action.clickAndHold(allItems.get(0)).moveToElement(allItems.get(7)).release().perform();

		// verify chon tu 1 den 8 thanh cong
		List<WebElement> allItemsSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[@class='ui-state-default ui-selectee ui-selected']"));

		// kiem tra size list co bang 8 hay ko
		Assert.assertEquals(allItemsSelected.size(), 8);
		
		//tao ra 1 array list de luu lai cac text selected
		ArrayList<String> allItemsSelectedText = new ArrayList<String>();

		// add tung text vao trong array list

		for (WebElement webElement : allItemsSelected) {
			allItemsSelectedText.add(webElement.getText());
			
			

		}
		// convert arraylist thanh array, thi moi so sanh dc
		Object[] selectedTextActual = (Object[])allItemsSelectedText.toArray();
		// so sanh
		Assert.assertEquals(selectedTextActual, selectedTextExpected);
		
		sleepInSecond(10);
		
		//test may cong ty
	}

// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai exception, chu ko stop cac testcase sau
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
