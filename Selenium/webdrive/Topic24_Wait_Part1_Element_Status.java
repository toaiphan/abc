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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic24_Wait_Part1_Element_Status {
	WebDriver driver;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
	}

	// @Test
	// element visible la co tren UI+ co trong DOM
	public void TC_01_Visible() {
		driver.get("https://m.facebook.com/");

		// Wait for Email Visble : cho cho email visible trong thoi gian 10s truoc khi
		// thao tac
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("m_login_email")));

		// sendkey vao email
		driver.findElement(By.id("m_login_email")).sendKeys("toai@gmail.com");
	}

	//@Test
	// invisible :khong hien thi UI + co/ko co trong DOM
	public void TC_02_invisible() {
		// th1: khong hien thi UI+ co trong Dom
		driver.get("http://live.demoguru99.com/");
		explicitWait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@id='header-account']//a[@title='My Account']")));
		// driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My
		// Account']")).click();
		// th2: khong hien thi ui+ khong co Dom
	}

	//@Test
	// : co trong DOM+ co hoac khong hien thi UI +
	public void TC_03_presence() {
		// th1: co trong dom + hien thi tren giao dien == visible
		driver.get("https://m.facebook.com/");

		// Wait for Email Visble : cho cho email visible trong thoi gian 10s truoc khi
		// thao tac
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("m_login_email")));

		// sendkey vao email
		driver.findElement(By.id("m_login_email")).sendKeys("toai@gmail.com");
		// th2 : co trong dom + ko hien thi tren giao dien == th1 cua invisible
		driver.get("http://live.demoguru99.com/");
		explicitWait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@id='header-account']//a[@title='My Account']")));
 
	}

	@Test
	// :k co trong DOM
	public void TC_04_Staleness() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		driver.findElement(By.xpath(".//*[@id='SubmitCreate']")).click();
		//page co status la A
		WebElement emailErrorMessage = driver.findElement(By.xpath(".//*[@id='create_account_error']"));
		
		driver.navigate().refresh();
		//page co status la B
		explicitWait.until(ExpectedConditions.stalenessOf(emailErrorMessage));
		

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
