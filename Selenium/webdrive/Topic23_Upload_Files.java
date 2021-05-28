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

public class Topic23_Upload_Files {
	WebDriver driver;
	
	//tao ra duong dan tuong doi, de van chay dc trên máy khác
	String source_folder = System.getProperty("user.dir");
	String image_name_01 ="hanoi";
	String image_name_02 ="hue";
	String image_name_03 ="saigon";

	String image_01_path = source_folder +"\\uploadFiles\\"+image_name_01;
	String image_02_path = source_folder +"\\uploadFiles\\"+image_name_02;
	String image_03_path = source_folder +"\\uploadFiles\\"+image_name_03;
	
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
// co 4 cach. nhung chu yeu lam c1: sendkeys. cac cach 2,3,4 it khi ap dung
	@Test
	public void TC_01_sendkeys() {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		//upload 1 lan 1 file
		uploadFile.sendKeys(image_01_path);
		sleepInSecond(1);
		//tim cai type=file roi sendkeys vao 
		uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFile.sendKeys(image_02_path);
		sleepInSecond(1);
		uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFile.sendKeys(image_03_path);
		sleepInSecond(50);
		
		//upload 1 lan nhieu file,ban firefox cu ko ho tro, khong tuong thich version
		//fail to connect to binary firefox...
		
		//uploadFile.sendKeys(image_01_path + "\n" +image_02_path + "\n" + image_03_path + "\n");
		
		//verify hinh anh hien thi co the dung javascrip executor
	}
	
	//cach 2 :L//co the upload file bang auto IT, chi hoat dong tren window// it su dung. chu yeu la dung sendkey.
	@Test
	public void TC_02_AutoIT() {
		
		//tao 1 folder autoIT script, copy file exe autoIT vao
		driver.get("");
		
		// lam nhu nguoi dung, auto IT lam buoc copy duong dan vao window form
		
		//executer 1 file exe, update 1 file 1 lan hay nhieu file 1 lan phu thuoc vao file .exe thuc thi
	//	chrome_auto_it = source_folder+"\\autoITscript\\chromeUploadOneTime.exe";
		//Runtime.getRuntime().exec(new String[] {chrome_auto_it,image_01_path});

	}
	//cach 3: dung robot class (topic24 )upload file II
	//cach 4: sikuli chi lam viec voi hinh anh, khi do phan giai thay doi=> script chay sai . muon thao tac voi element nao thi phai chup lai hinh anh do

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
