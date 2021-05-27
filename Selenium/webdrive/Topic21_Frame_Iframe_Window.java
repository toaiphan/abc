package webdrive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic21_Frame_Iframe_Window {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_Iframe() {
		// mo trang
		driver.get("https://kyna.vn/");

		// switch to Facebook iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='face-content']/iframe")));

		// kiem tra so luong like co dung ko
		System.out.println(driver.findElement(By.className("_1drq")).getText());
		Assert.assertEquals(driver.findElement(By.className("_1drq")).getText(), "169K likes");

		// switch to default content
		driver.switchTo().defaultContent();

		// check search textbox displayed
		Assert.assertTrue(driver.findElement(By.id("live-search-bar")).isDisplayed());

		// switch wechat iframe
		driver.switchTo().frame("cs_chat_iframe");
		driver.findElement(By.xpath("//div[@class='meshim_widget_components_chatButton_Button ltr ng-scope']")).click();

		// kiem tra chat box hien thi
		String placeholer = driver.findElement(By.xpath(
				"//input[@class='input_name standalone mobile_error_icon meshim_widget_widgets_TextField ltr ng-pristine ng-valid desktop'])"))
				.getAttribute("placeholder");
		System.out.println(placeholer);

		// input text vao chat box, enter

		// kiem tra hien thi dung ko

		// switch to defaut content
		driver.switchTo().defaultContent();

		// search "java" , click tim kiem, kiem tra ket qua
		driver.findElement(By.id("live-search-bar")).sendKeys("java");

	}

	@Test
	public void TC_02_window_tab() {
		driver.get("https://kyna.vn/");

		// lay ra id tai tab co driver dang dung
		String parentID = driver.getWindowHandle();

		// click to vietnamwork
		driver.findElement(By.xpath("//img[@alt='VietnamWorks']")).click();
		sleepInSecond(5);
		// switch driver qua vietnamwork

		switchToWindowByID(parentID);
		sleepInSecond(5);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.vietnamworks.com/?utm_source=from_kyna");

		// switch ve lai parent
		String childID = driver.getWindowHandle();
		switchToWindowByID(childID);
		Assert.assertEquals(driver.getCurrentUrl(), "https://kyna.vn/");

		// switch bang title
		// de lay title : dung f12, console, document.title
		switchToWindowByTitle("Tuyển dụng, việc làm, tìm việc làm nhanh mới nhất | VietnamWorks");
		sleepInSecond(5);

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.vietnamworks.com/?utm_source=from_kyna");
		
		areAllTabCloseWithoutParent(parentID);

	}

// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai exception, chu ko stop cac testcase sau
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

// ham switch chi dung cho truong hop 2 tab/2window
	public void switchToWindowByID(String parentID) {

		// lay tat ca id cua cac cua so
		Set<String> allWindows = driver.getWindowHandles();
		// neu id nao khac voi parent thi nhay qua window do
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
			//

		}
	}
	// neu can swich co nhieu tab : can dung ham title :1h20p topic 21

	public void switchToWindowByTitle(String pageTitle) {
		// lay ra tat ca id cua window/tab dang co
		Set<String> allWindows = driver.getWindowHandles();

		// dung for de duyet qua tung window/tab
		for (String runWindows : allWindows) {

			driver.switchTo().window(runWindows);
			// lay ra title cua tab
			String currentWin = driver.getTitle();
			// kiemn tra title cua page nao bang title mong muon
			if (currentWin.equals(pageTitle)) {
				break;

			}

		}
	}

	public boolean areAllTabCloseWithoutParent(String parentID) {
		// lay tat ca id cua cac cua so
		Set<String> allWindows = driver.getWindowHandles();
		// neu id nao khac voi parent thi nhay qua window do
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();

			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
