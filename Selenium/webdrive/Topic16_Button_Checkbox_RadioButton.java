package webdrive;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic16_Button_Checkbox_RadioButton {
	WebDriver driver;
// lam viec voi default dropdown  can khai bai select
	Select select;
	JavascriptExecutor jsExecutor;
	// khai bao xpath check box de dung lai nhieu lan
	By firstCheckbox = By.xpath("//input[@value='Anemia']");
	By secondCheckbox = By.xpath("//input[@value='Asthma']");
	By thirdCheckbox = By.xpath("//input[@value='Arthritis']");
	By allCheckbox = By.xpath("//input[@type='checkbox']");
	// khai bao xpath cac radio de dung lai nhieu lan
	By firstRadio = By.xpath("//input[@value='3-4 days']");
	By secondRadio = By.xpath("//input[@value='I have a strict diet']");

	@BeforeClass
	public void beforeClass() {
		// neu muon chay voi chcrome thi su dung 2 dong nay
		// System.setProperty("webdriver.chrome.driver",
		// ".\\browserDriver\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// @Test
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
		// lam cho login button quay lai dissable
		driver.navigate().refresh();
		// nhan lai vao dang nhap
		driver.findElement(By.cssSelector(".popup-login-tab-item.popup-login-tab-login")).click();
		// khai bao lai login button de tranh loi sau khi F5 bi refesh
		loginButton = driver.findElement(By.cssSelector(".fhs-btn-login"));
		// verify login button is dissable
		Assert.assertFalse(loginButton.isEnabled());
		// remove thuoc tinh disable// han che su dung, khong phai usercase
		removeDisabledAttribute(loginButton);
		sleepInSecond(2);
		// click to login button
		loginButton.click();

		// verify thong bao sau khi click
		Assert.assertEquals(driver
				.findElement(By.xpath("//input[@id='login_username']/parent::div/following-sibling::div")).getText(),
				"Thông tin này không thể để trống");
		Assert.assertEquals(driver
				.findElement(By.xpath("//input[@id='login_password']/parent::div/following-sibling::div")).getText(),
				"Thông tin này không thể để trống");

		// input[@id='login_username']/parent::div/following-sibling::div
		// 39'55 topic 16 sang phan check box
		// radio button chi con 1, check box chon dc nhieu
	}

	// @Test
	public void TC_02_Default_Radio_Checkbox() {
		driver.get("https://automationfc.github.io/multiple-fields");
		// verify 3 checkboxes + 2 radio deselected
		Assert.assertFalse(driver.findElement(firstCheckbox).isSelected());
		Assert.assertFalse(driver.findElement(secondCheckbox).isSelected());

		Assert.assertFalse(driver.findElement(thirdCheckbox).isSelected());
		Assert.assertFalse(driver.findElement(firstRadio).isSelected());

		Assert.assertFalse(driver.findElement(secondRadio).isSelected());

		// click vao 3 check box va 2 radio
		driver.findElement(firstCheckbox).click();
		driver.findElement(secondCheckbox).click();

		driver.findElement(thirdCheckbox).click();

		driver.findElement(firstRadio).click();

		driver.findElement(secondRadio).click();
		sleepInSecond(5);
		// verify 3 check box+ 2 radio selected
		// ham isSelected chi dung cho the input ( chi kiem tra duoc cho the input)
		Assert.assertTrue(driver.findElement(firstCheckbox).isSelected());
		Assert.assertTrue(driver.findElement(secondCheckbox).isSelected());

		Assert.assertTrue(driver.findElement(thirdCheckbox).isSelected());
		Assert.assertTrue(driver.findElement(firstRadio).isSelected());

		Assert.assertTrue(driver.findElement(secondRadio).isSelected());
		// select all checkbox trong form
		// f5 lai trang cho ve ko tich check box nao
		driver.navigate().refresh();
		List<WebElement> checkboxes = driver.findElements(allCheckbox);
		// select . can de thoi gian , nhanh qua se fail
		for (WebElement checkbox : checkboxes) {
			checkbox.click();
			sleepInSecond(1);
		}

		// verify xem da click het chua
		for (WebElement checkbox : checkboxes) {
			Assert.assertTrue(checkbox.isSelected());
		}
		// deselected all

		for (WebElement checkbox : checkboxes) {
			checkbox.click();
			sleepInSecond(1);

		}
		// verify xem da click het chua
		for (WebElement checkbox : checkboxes) {
			Assert.assertFalse(checkbox.isSelected());
		}

	}

	@Test
// do custom the input ko the click ( vi bi an di), nhung van verify dc. de click duoc thi can dung den jsexecur
	public void TC_03_Custom_Radio_Checkbox() {
		driver.get("https://material.angular.io/components/checkbox/examples");
		By checkedCheckbox = By.xpath("//span[text()='Checked']//preceding-sibling::span/input");
		// click
		clickByJavascript(driver.findElement(checkedCheckbox));
		// verify
		Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());

	}

//ham de remove thuoc tinh disble cua o login
	public void removeDisabledAttribute(WebElement element) {
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", element);

	}

	// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai
	// exception, chu ko stop cac testcase sau
	// ham de click vao the input(custom checkbox)
	public void clickByJavascript(WebElement element) {
		jsExecutor.executeScript("arguments[0].click();", element);

	}

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
