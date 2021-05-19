package webdrive;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baitap_xpath_css {
	WebDriver driver;
	String firstName, midleName, lastName, email,actual;

	@BeforeClass
	public void beforeClass() {

		// mo web browser
		driver = new FirefoxDriver();
		// cho cho tim element 30s ( cho tat ca element)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// mo to man hinh web browser
		driver.manage().window().maximize();


	}

//@Test
	public void TC_01() throws InterruptedException {

		// mo trang web test
		driver.get("http://live.demoguru99.com/");

		// click vao my account
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		// click vao login
		driver.findElement(By.id("send2")).click();

		// verify
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(),
				"This is a required field.");

		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),
				"This is a required field.");

	}

//@Test
//Login with invalid email
	public void TC_02() throws InterruptedException {

		// mo trang web test
		driver.get("http://live.demoguru99.com/");

		// click vao my account
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		// nhap email+ pass invalid
		driver.findElement(By.id("email")).sendKeys("21321312@12321312.1232131");

		driver.findElement(By.id("pass")).sendKeys("123456");

		// click vao login
		driver.findElement(By.id("send2")).click();

		// verify
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

//@Test
//Login with invalid email
	public void TC_03() throws InterruptedException {
		// mo trang web test
		driver.get("http://live.demoguru99.com/");

		// click vao my account
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		// nhap email+ pass invalid
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");

		driver.findElement(By.id("pass")).sendKeys("123");

		// click vao login
		driver.findElement(By.id("send2")).click();

		// verify
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(),
				"Please enter 6 or more characters without leading or trailing spaces.");

	}

//@Test
//Login with invalid email
	public void TC_04() throws InterruptedException {
		// mo trang web test
		driver.get("http://live.demoguru99.com/");

		// click vao my account
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		// nhap email+ pass invalid
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");

		driver.findElement(By.id("pass")).sendKeys("123456");

		// click vao login
		driver.findElement(By.id("send2")).click();

		// verify
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(),
				"Invalid login or password.");

	}

	@Test
	public void TC_05() throws InterruptedException {
		// create new account
		// mo trang web
		// Random rd = new Random();
		// int number1 = rd.nextInt(4000);

		driver.get("http://live.demoguru99.com/");

		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();

		driver.findElement(By.id("firstname")).sendKeys("toai");

		driver.findElement(By.id("middlename")).sendKeys("anh");

		driver.findElement(By.id("lastname")).sendKeys("phan");

		email = "toaiphan" + rd() + "@gmail.com";
		driver.findElement(By.id("email_address")).sendKeys(email);
		System.out.println(email);

		driver.findElement(By.id("password")).sendKeys("123456");

		driver.findElement(By.id("confirmation")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@title='Register']")).click();

		String sussess = driver
				.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText();
		Assert.assertEquals(sussess, "Thank you for registering with Main Website Store.");

		// step 7 verify fisrtname,lastname,email
		firstName = driver.findElement(By.xpath("//p[contains(.,'Change Password')]")).getText();
		System.out.println(firstName);
		
		actual = "toai anh phan\n"+email+"\n"+"Change Password";
		System.out.println(actual);
		Assert.assertEquals(actual, firstName);
		
//		toai anh phan
//		toaiphan3032@gmail.com
//		Change Password

	}

	@AfterClass
	public void afterClass() {

	}

//public int randomNumber() {
//	Random rand = new Random();
//	return rand.nextInt(9999);
//}
	public int rd() {
		// Tạo mới 1 đối tượng Random
		// sử dụng từ khóa new
		Random rd = new Random();
		int randomx = rd.nextInt(4000);
		return randomx;
	}
}
