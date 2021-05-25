package webdrive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic1819_User_Interaction {
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

	// @Test
	// click and hold (46'47 topic 18)
	public void TC_02_Click_And_Hold() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		String[] selectedTextExpected = { "1", "2", "3", "4", "5", "6", "7", "8" };

		// khai bao list element, moi element la 1 so(1 o so)
		List<WebElement> allItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));

		// click and hold vao o so 1, move den o so 8, tha chuot ( ham release de tha
		// chuot)
		action.clickAndHold(allItems.get(0)).moveToElement(allItems.get(7)).release().perform();

		// verify chon tu 1 den 8 thanh cong
		List<WebElement> allItemsSelected = driver
				.findElements(By.xpath("//ol[@id='selectable']/li[@class='ui-state-default ui-selectee ui-selected']"));

		// kiem tra size list co bang 8 hay ko
		Assert.assertEquals(allItemsSelected.size(), 8);

		// tao ra 1 array list de luu lai cac text selected
		ArrayList<String> allItemsSelectedText = new ArrayList<String>();

		// add tung text vao trong array list

		for (WebElement webElement : allItemsSelected) {
			allItemsSelectedText.add(webElement.getText());

		}
		// convert arraylist thanh array, thi moi so sanh dc
		Object[] selectedTextActual = (Object[]) allItemsSelectedText.toArray();
		// so sanh
		Assert.assertEquals(selectedTextActual, selectedTextExpected);

		sleepInSecond(10);
	}
	// @Test

	// giong nhu kieu ctrl roi chon random
	public void TC_03_Click_And_Hold_Random() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");

		// khai bao list element, moi element la 1 so(1 o so)
		List<WebElement> allItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		// 1.nhan phim ctrl

		action.keyDown(Keys.CONTROL).perform();
		// 2.click vao 1 4 7 12
		action.click(allItems.get(0)).click(allItems.get(3)).click(allItems.get(6)).click(allItems.get(11)).perform();
		// 3. nha phim ctrl
		action.keyUp(Keys.CONTROL).perform();

		// verify
		List<WebElement> allItemsSelected = driver
				.findElements(By.xpath("//ol[@id='selectable']/li[@class='ui-state-default ui-selectee ui-selected']"));
		Assert.assertEquals(allItemsSelected.size(), 4);

	}

	// @Test

	// click dup
	public void TC_04_Double_Click() {
		// mo trang test
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// khai bao elemen
		element = driver.findElement(By.xpath("//button[@ondblclick='doubleClickMe()']"));
		// click dup vao element
		action.doubleClick(element).perform();

		// verify
		Assert.assertTrue(driver.findElement(By.id("demo")).isDisplayed());
		sleepInSecond(5);
	}

	// @Test
	public void TC_05_Right_Click() {
		// mo trang test
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		// lay element de click chuot phai
		element = driver.findElement(By.xpath("//span[text()='right click me']"));

		// click chuot phai
		action.contextClick(element).perform();

		// hover to quit
		element = driver.findElement(By.xpath("//span[text()='Quit']//parent::li"));
		action.moveToElement(element).perform();

		// verify quit co them hover/visible status
		String quitClassAttribute = element.getAttribute("class");

		System.out.println(quitClassAttribute);

		Assert.assertTrue(quitClassAttribute.contains("context-menu-visible"));
		Assert.assertTrue(quitClassAttribute.contains("context-menu-hover"));
		// hoac co the verify bang isdisplay nhu vi du tren

		sleepInSecond(5);
	}

	// nhung chuc nang khong nen lam auto :captcha( kiem tra nguoi dung
	// that),OCR(nhan dien hinh anh- bien so xe,khuon mat),SMS,OTP,...QR
	// CODE,BARCODE,bieu do: chart,canvas,flash,flex
	// => khi nao co nhieu tgian moi lam, set do uu tien thap vi lam mat nhieu thoi
	// gian va do on dinh thap, phai maintain nhieu
	// @Test
	public void TC_06_Drag_And_Drop_HTML4() {
		// mo trang test
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
		// lay ra 2 thang nguon va dich
		// dung by.id thi lai khong chay duoc
		WebElement sourceCircle = driver.findElement(By.cssSelector("#draggable"));
		WebElement targetCircle = driver.findElement(By.cssSelector("#droptarget"));
		// keo nguon vao dich
		action.dragAndDrop(sourceCircle, targetCircle).perform();

		// hoac co the lam bang click and hold
		// action.clickAndHold(sourceCircle).moveToElement(targetCircle).release().perform();
		sleepInSecond(5);
		// verify
		Assert.assertEquals(targetCircle.getText(), "You did great!");
		sleepInSecond(5);
	}

	@Test
	public void TC_07_Drag_And_Drop_HTML5() {
		// co 2 cach
		//c1: dung thu vien co san 
		//ca2 dung toa do
		// xem tu 46p15 topic  19
		driver.get("");
		sleepInSecond(5);
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
