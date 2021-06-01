package webdrive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic28_Wait_Part4_Mixing {
	WebDriver driver;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	@Test
	// TH1: tim thay element , ko can cho het timeout nen implicit va explicit khong anh huong den nhau
	public void TC_01_Element_Found() {

		// mo trang facebook
		driver.get("https://facebook.com/");

		// explicit wait : cho cho element email visible thi sendkey vao

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("m_login_email")))
				.sendKeys("phan anh toai");
		// implicit wait : click vao login
		driver.findElement(By.name("login")).click();

	}
	//TH2: chi dung implicit wait + khong tim thay element=> cho het timeout cua implicit wait

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
