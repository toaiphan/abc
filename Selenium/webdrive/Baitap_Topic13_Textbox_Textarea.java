package webdrive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Baitap_Topic13_Textbox_Textarea {
	WebDriver driver;
	String email;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		email = "toaiphan"+rd()+"@gmail.com";
	}

	@Test
	public void TC_01_Textbox_Textarea() {
		driver.get("http://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//input[@onblur='validateuserid();']")).clear();
		driver.findElement(By.xpath("//input[@onblur='validatepassword();']")).clear();
		driver.findElement(By.xpath("//input[@onblur='validateuserid();']")).sendKeys("mngr328138");
		driver.findElement(By.xpath("//input[@onblur='validatepassword();']")).sendKeys("gYreqEg");
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(By.xpath("//input[@onblur='validatecustomername();']")).sendKeys("phan anh toai");
		//click female
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.xpath("//input[@onblur='validatedob();']")).sendKeys("1995-06-08");
		driver.findElement(By.xpath("//textarea[@onblur='validateAddress();']")).sendKeys("59 Dinh thon");
		driver.findElement(By.xpath("//input[@onblur='validateCity();']")).sendKeys("ha noi");
		driver.findElement(By.xpath("//input[@onblur='validateState();']")).sendKeys("viet nam");
		driver.findElement(By.xpath("//input[@onblur='validatePIN();']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@onblur='validateTelephone();']")).sendKeys("0342787575");
		driver.findElement(By.xpath("//input[@onblur='validateEmail();']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@onblur='validatepassword();']")).sendKeys("123456");
		sleepInSecond(10);
		//click submit
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		sleepInSecond(10);
		
		
		
		
		
		
		
		
		
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
	public int rd() {
		// Tạo mới 1 đối tượng Random
		// sử dụng từ khóa new
		Random rd = new Random();
		int randomx = rd.nextInt(4000);
		return randomx;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
