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

public class Topic27_Wait_Part3_StaticWait {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
//fix cung wait, chi nen dung voi IE11
	@Test
	//THUA wait
	public void TC_01_10S() {
		//mo trang
		driver.get("http://juliemr.github.io/protractor-demo/");
		
		//send 5+5
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("5");
		

		
		//click gobutton
		driver.findElement(By.xpath(".//*[@id='gobutton']")).click();

		
		//wait
		sleepInSecond(10);
		
		//verify
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='10']")).isDisplayed());
	}
	
	@Test
	//vua du wait
	public void TC_02_3S() {
		//mo trang
		driver.get("http://juliemr.github.io/protractor-demo/");
		
		//send 5+5
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("5");
		

		
		//click gobutton
		driver.findElement(By.xpath(".//*[@id='gobutton']")).click();

		
		//wait
		sleepInSecond(3);
		
		//verify
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='10']")).isDisplayed());
	}
	
	@Test
	//thieu wait
	public void TC_03_1S() {
		//mo trang
		driver.get("http://juliemr.github.io/protractor-demo/");
		
		//send 5+5
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("5");
		

		
		//click gobutton
		driver.findElement(By.xpath(".//*[@id='gobutton']")).click();

		
		//wait
		sleepInSecond(1);
		
		//verify
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='10']")).isDisplayed());
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
