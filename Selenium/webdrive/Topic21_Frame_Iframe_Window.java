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

public class Topic21_Frame_Iframe_Window {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Iframe() {
		//mo trang
		driver.get("https://kyna.vn/");
		
		// switch to Facebook iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='face-content']/iframe")));
		
		// kiem tra so luong like co dung ko
		System.out.println(driver.findElement(By.className("_1drq")).getText());
		Assert.assertEquals(driver.findElement(By.className("_1drq")).getText(), "169K likes");
		
		// switch to default content
		
		
		//check search textbox displayed
		
		
		// switch wechat iframe
		
		
		//kiem tra chat box hien thi
		
		
		//input text vao chat box, enter
		
		//kiem tra hien thi dung ko
		
		
		//switch to defaut content
		
		
		//search "java" , click tim kiem, kiem tra ket qua 
	}
	@Test
	public void TC_02_() {
		driver.get("");

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
