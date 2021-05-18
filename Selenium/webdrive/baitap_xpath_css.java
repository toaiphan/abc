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
@BeforeClass
	public void beforeClass() {
	
		// mo  web browser 
		driver = new FirefoxDriver();
		
		// mo to man hinh web browser 
		driver.manage().window().maximize();
		
		 //chờ trong khoản 10s để tìm kiếm element o lenh tiep theo
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   
		  
  }

//@Test
//	public void TC_01() throws InterruptedException {
//		
//		// mo trang web test
//		driver.get("http://live.demoguru99.com/");
//		Thread.sleep(2000);
//		
//	    // click vao my account
//		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//		Thread.sleep(2000);
//		// click vao login
//		driver.findElement(By.id("send2")).click();
//		Thread.sleep(2000);
//		//verify 
//		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(),"This is a required field.");
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),"This is a required field.");
//		Thread.sleep(2000);
//  }
//@Test
////Login with invalid email
//public void TC_02() throws InterruptedException {
//	
//	// mo trang web test
//	driver.get("http://live.demoguru99.com/");
//	Thread.sleep(2000);
//	
//    // click vao my account
//	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//	Thread.sleep(2000);
//	
//	// nhap email+ pass invalid
//	driver.findElement(By.id("email")).sendKeys("21321312@12321312.1232131");
//	Thread.sleep(2000);
//	driver.findElement(By.id("pass")).sendKeys("123456");
//	Thread.sleep(2000);
//	
//	// click vao login
//	driver.findElement(By.id("send2")).click();
//	Thread.sleep(2000);
//	
//	//verify 
//	Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
//	Thread.sleep(2000);
//  
//}
//
//@Test
////Login with invalid email
//public void TC_03() throws InterruptedException {
//	// mo trang web test
//		driver.get("http://live.demoguru99.com/");
//		Thread.sleep(2000);
//		
//	    // click vao my account
//		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//		Thread.sleep(2000);
//		
//		// nhap email+ pass invalid
//		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
//		Thread.sleep(2000);
//		driver.findElement(By.id("pass")).sendKeys("123");
//		Thread.sleep(2000);
//		
//		// click vao login
//		driver.findElement(By.id("send2")).click();
//		Thread.sleep(2000);
//		
//		//verify 
//		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
//		Thread.sleep(2000);
	
//}
 
//@Test
////Login with invalid email
//public void TC_04() throws InterruptedException {
//	// mo trang web test
//			driver.get("http://live.demoguru99.com/");
//			Thread.sleep(2000);
//			
//		    // click vao my account
//			driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//			Thread.sleep(2000);
//			
//			// nhap email+ pass invalid
//			driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
//			Thread.sleep(2000);
//			driver.findElement(By.id("pass")).sendKeys("123456");
//			Thread.sleep(2000);
//			
//			// click vao login
//			driver.findElement(By.id("send2")).click();
//			Thread.sleep(2000);
//			
//			//verify 
//			Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(),"Invalid login or password.");
//			Thread.sleep(2000);
//		
//	
//}
@Test
public void TC_05() throws InterruptedException {
	// create new account
	// mo trang web
	//Random rd = new Random();
    //int number1 = rd.nextInt(4000);
    
	driver.get("http://live.demoguru99.com/");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();	
	Thread.sleep(2000);
	driver.findElement(By.id("firstname")).sendKeys("toai");
	Thread.sleep(2000);
	driver.findElement(By.id("middlename")).sendKeys("anh");
	Thread.sleep(2000);
	driver.findElement(By.id("lastname")).sendKeys("phan");
	Thread.sleep(2000);
	
	driver.findElement(By.id("email_address")).sendKeys("toaiphan"+ rd() +"@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.id("password")).sendKeys("123456");
	Thread.sleep(2000);
	driver.findElement(By.id("confirmation")).sendKeys("123456");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@title='Register']")).click();
	Thread.sleep(2000);
	
	String sussess = driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText();
	Assert.assertEquals(sussess,"Thank you for registering with Main Website Store.");
	Thread.sleep(2000);
	
	
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
