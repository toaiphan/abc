package webdrive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic16_Button_Checkbox_RadioButton {
	WebDriver driver;
// lam viec voi default dropdown  can khai bai select
	Select select;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		// nhan vao dang nhap
		driver.findElement(By.cssSelector(".popup-login-tab-item.popup-login-tab-login")).click();
		WebElement loginButton = driver.findElement(By.cssSelector(".fhs-btn-login"));
		// verify login button is dissable
		boolean status = loginButton.isEnabled();
		Assert.assertFalse(status);
		// input email va pass word
		driver.findElement(By.cssSelector("#login_username")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("#login_password")).sendKeys("123456");
		sleepInSecond(2);

		// verify login button is enabled
		status = loginButton.isEnabled();
		Assert.assertTrue(status);

		// click to login button
		loginButton.click();
		// verify thong bao email mat khau sai
		String errorMessage = driver.findElement(By.cssSelector(".fhs-login-msg")).getText();
		Assert.assertEquals(errorMessage, "Số điện thoại/Email hoặc Mật khẩu sai!");
		sleepInSecond(5);
		// clear data
		driver.findElement(By.cssSelector("#login_username")).clear();
		driver.findElement(By.cssSelector("#login_password")).clear();
		//lam cho login button quay lai dissable
		driver.navigate().refresh();
		// nhan lai vao dang nhap
		driver.findElement(By.cssSelector(".popup-login-tab-item.popup-login-tab-login")).click();
		//khai bao lai login button de tranh loi sau khi F5 bi refesh
		loginButton = driver.findElement(By.cssSelector(".fhs-btn-login"));
		// verify login button is dissable
		Assert.assertFalse(loginButton.isEnabled());
		// remove thuoc tinh disable// han che su dung, khong phai usercase
		removeDisabledAttribute(loginButton);
		sleepInSecond(2);
		// click to login button
		loginButton.click();
		
		// verify thong bao sau khi click 
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='login_username']/parent::div/following-sibling::div")).getText(), "Thông tin này không thể để trống");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='login_password']/parent::div/following-sibling::div")).getText(), "Thông tin này không thể để trống");

		//input[@id='login_username']/parent::div/following-sibling::div
		//39'55 topic 16 sang phan check box
	}

	@Test
	public void TC_02_() {
		driver.get("");

	}
// ham de remove thuoc tinh disble cua o login
	public void removeDisabledAttribute(WebElement element) {
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled')",element);
		
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
