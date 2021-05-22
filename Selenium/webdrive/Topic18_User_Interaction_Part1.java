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

	@Test
	public void TC_01_() {
		driver.get("https://www.myntra.com/");
		element = driver.findElement(By.xpath("//a[@data-group='kids']"));

		// hover to Element , can co perform de thuc thi
		action.moveToElement(element).perform();

		sleepInSecond(5);
		//khi chay test se bi chiem chuot=> khong dung chuot khi chay test
		//click vao home bath
		driver.findElement(By.xpath("//a[text()='Home & Bath']")).click();
		//verify da vao dc trang home bath ( tu lam dc)
	}

	@Test
	//click and hold (46'47 topic 18)
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
