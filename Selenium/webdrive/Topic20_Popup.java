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

public class Topic20_Popup {
	WebDriver driver;
	Boolean status;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() {
		//mo trang
		driver.get("https://zingpoll.com/");
		
		
		//click vao login form
		driver.findElement(By.id("Loginform")).click();
		
		//kiem tra login form da hien thi""
		status = driver.findElement(By.className("//div[@class='modal-dialog modal_dialog_custom']")).isSelected();
		Assert.assertTrue(status);
		
		//click vao close
		driver.findElement(By.xpath("//button[@class='close' and @onclick='ResetForm()' ]")).click();
		
		//kiem tra login form ko hien thi
		status = driver.findElement(By.className("//div[@class='modal-dialog modal_dialog_custom']")).isSelected();
		Assert.assertFalse(status);
		
		//click lai vao login form
		driver.findElement(By.id("Loginform")).click();
		
		
		// dien user name :automationfc.vn@gmail.com , pass la automationfc
		
		driver.findElement(By.id("loginEmail")).sendKeys("automationfc.vn@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("automationfc");
		
		//click vao signin
		driver.findElement(By.id("button-login")).click();
		
		
		//kiem tra login thanh cong (da hien thi ten cua user)
		Assert.assertTrue(driver.findElement(By.className("username")).getText().contains("Automation Testing"));
		
		sleepInSecond
		
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
