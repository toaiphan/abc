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

public class Topic27_Wait_Part3_ExplicitWait {
	WebDriver driver;
	WebDriverWait explicitWait;
	Alert alert;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
	}

	//@Test
	public void TC_01_Alert_Presence() {
		// mo trang
		driver.get("http://demo.guru99.com/v4/index.php");

		// dung explicit de cho 10s den khi element co the click

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.name("btnLogin")));
		// click login

		driver.findElement(By.name("btnLogin")).click();

		// alert displayed

		// cho cho alert hiien thi (15s)

		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		// Switch to Alert
		// alert = driver.switchTo().alert();

		// get text cua alert
		System.out.println("Alert text" + alert.getText());

		// accept alert
		alert.accept();

		// alert senkey danhf cho alert cho phep viet chu vao
		// alert.sendKeys(toai);

		// cancel alert
		// alert.dismiss();

	}
	//@Test
	public void TC_02_Visible() {
		// mo trang
		driver.get("http://juliemr.github.io/protractor-demo/");

		// send 5+5
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("5");

		// click gobutton
		driver.findElement(By.xpath(".//*[@id='gobutton']")).click();
// cho cho visible element
		WebElement resultText = explicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='10']")));
		// verify

		Assert.assertTrue(resultText.isDisplayed());
	}
	@Test
	public void TC_03_Invisible() {
		// mo trang
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

		// cho cho den khi co the cick start button, sau do click
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='start']/button"))).click();
		// cho cho den khi element loadding invisible
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading']")));

		// verify
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='finish']/h4")).getText(),"Hello World!");
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
