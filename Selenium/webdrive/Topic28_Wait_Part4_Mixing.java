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
	//TH3:  implicit 10s, explicit 5s,+ko tim thay element ( chu y apply implicit cho 1 ham su dung explixit )
	//5s se co exception, 10s moi het timeout
	//TH4 : implicit 5s, explicit 10s+ ko tim thay element
	//10s se co exception, 10s moi het timeout 
	// bao loi 10s hay 5s phu thuoc vao ham explicit vi implicit nam ben trong explicit
	// => implicit: thoi gian find, explicit thoi gian thow exception, , timeout tong thi lon nhat trong 2
	
	//TH5 : chi dung explicit theo locator , time out theo explicit
	//th6 : chi dung explicit theo webelement, time out la OS neu ko find dc element ( vi ham find element nam o ngoai)
// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai exception, chu ko stop cac testcase sau
	
	// ham try catch, vao try neu xay ra exception se nhay den catch, ma ko chay tiep cac lenh sau, Neu muon thi can try catch tung lenh
	
	
	//nen dung explicit hay implicit
	//-Nen cung ca 2 loai : 2 thang se cung duoc kich hoat hoac tre hon 1 chut, se chay lau hon nhung chac chan hon
	// ko co wait nao tot nhat, tuy tung truong hop
	
	
	
	
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
