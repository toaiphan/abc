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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic17_Alert {
	WebDriver driver;
	Alert alert;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Test
	public void TC_01_BankGuru() {
		driver.get("http://demo.guru99.com/v4/index.php");
		sleepInSecond(2);
		//click login
		driver.findElement(By.name("btnLogin")).click();
		sleepInSecond(2);

		//alert displayed
		//Switch to Alert
		alert = driver.switchTo().alert();
		sleepInSecond(2);

		//get text cua alert
		System.out.println("Alert text" + alert.getText());
		sleepInSecond(2);

		//accept alert
		alert.accept();
		sleepInSecond(2);
		//alert senkey danhf cho alert cho phep viet chu vao
		//alert.sendKeys(toai);

		//cancel alert
		//alert.dismiss();
	}

	//@Test
	public void TC_02_JS_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//1.alert accept
		//click vao de hien ra alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();

		//switch to alert
		alert = driver.switchTo().alert();
		
		//verify alert text
		Assert.assertEquals(alert.getText(),"I am a JS Alert");
		//accept alert
		alert.accept();
		//verify accept alert sussess
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked an alert successfully");
	}

// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai exception, chu ko stop cac testcase sau
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void TC_03_Authentication_Alert() {
		String username = "admin";
		String password= "admin";
		// xac thuc qua duong link luon, ko hien len alert nua
		driver.get("http://"+ username + ":"+password +"@"+"the-internet.herpkuapp.com/basic_auth");
		//verryfi thanh cong
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Basic Auth']")).isDisplayed());
				
	}
	
	//neu nhu khong biet troc duong link thi lam bang cach , get link do va sua link do bang ham ben duoi
	
	//public void handleAuthenticationAlert(String link,String name,String password){
	//String splitLInk[]=link.split("//");
	//link= splitLink[0]+"//"+username+":"+password+"@"+splitLink[1];
	//driver.get(link);
	//}
	
	//cach 3 la dung autoIT
//}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
