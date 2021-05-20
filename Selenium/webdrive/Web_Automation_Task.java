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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Web_Automation_Task {
	WebDriver driver;
	String actual, expected;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_() {
		// open tiki
		driver.get("https://tiki.vn/");
		// search iphone 11
		driver.findElement(By.xpath("//input[@class='FormSearch__Input-sc-1fwg3wo-2 ehiBA']")).sendKeys("iphone 11");
		// click to search
		driver.findElement(By.xpath("//button[@class='FormSearch__Button-sc-1fwg3wo-3 knOqgr']")).click();
		// verify result is shown for the mentioned product
		expected = "Kết quả tìm kiếm cho `iphone 11`:";
		actual = driver.findElement(By.cssSelector(".title>h1")).getText();
		Assert.assertEquals(actual, expected);
		// click to "gia thap"
		driver.findElement(By.xpath("//div[@class='sort-list']/child::a[text()='Giá thấp']")).click();
		// get product name
		List<WebElement> listName = driver.findElements(By.xpath("//div[@class='name']/child::span"));
		listName = driver.findElements(By.xpath("//div[@class='name']/child::span"));
		// get gia
		List<WebElement> listGia = driver.findElements(By.xpath("//div[@class=\"price-discount__price\"]"));
		listGia = driver.findElements(By.xpath("//div[@class=\"price-discount__price\"]"));
		// in ten va gia ra console
		for (int i = 0; i < listName.size(); i++) {

			System.out.println("Ten san pham: " + listName.get(i).getText());
			System.out.println("Gia san pham: " + listGia.get(i).getText());

		}
	}

	// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai
	// exception, chu ko stop cac testcase sau
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
