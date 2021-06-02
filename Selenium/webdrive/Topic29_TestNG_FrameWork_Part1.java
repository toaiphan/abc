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


//1.SW TESTING LEVEL
//unit testing:  thuc hien  boi Dev, dung de test code
//Integration testing : test tich hop./ test api ,thuc hien boi tester , ket hop nhieu chuc nang voi nhau 
//vi du dang ki + login
//system testing : gia lap nhu moi truong thuc
//Aceptance testing : 2 loai anpha :khach hang hoac tester test, beta : end user test, nguoi dung app thuc te test
//
//2.AUTOMATION TESTING LEVEL
//- unit test : Junit,TestNG
//- API testing : Postman ,rest assured
//-Gui test : chuc nang nguoi dung : slenium , appium
//- cac cong ty lam product thi lam unit test nhieu hon, con lam out source thi gui test nhieu hon//

//3.Automation testing tool : free/open source : selenium, robot farm ,katalon ( ban 7 bat dau tinh phi) , cac loai tool nay co the xem code va sua code
//co phi : nhu test complete, katalon studio enterprise...
//4. Automation testing farmwork : tuy theo ngon ngu lap trung : vi du java (thi co JUnit,testNG,.Assert.,hamscrest)
//5. Automation testing frame work type :
//6.TestNG framework
//TestNG plugin : khong phai la thu vien, la test NG runner, ho tro chay testcase
//Library: thu vien bo tro cho viet code

public class Topic29_TestNG_FrameWork_Part1 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() {
		driver.get("");
	}
	@Test
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
