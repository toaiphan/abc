package webdrive;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic13_Textbox_Textarea {
	WebDriver driver;
	// khai bao userIDValue, password de cho TC_02 co the su dung lai dc
	// khai bao loginPageURL de khi URL thay doi chi thay doi 1 lan URL o dau tien
	// khai bao bien customerID de cho TC_04 su dung lai tu TC_03
	String userIDValue, password, loginPageURL, customerID;
	// tao ra 1 bo du lieu de su dung
	String name, dateOfBirth, address, city, state, pin, phone, email, gender;
	// khai bao element o day, de co the dung chung tao customer moi va edit
	By customerNameTextbox = By.name("name");
	By dateOfBirthTextbox = By.name("dob");
	By addressTextArea = By.name("addr");
	By cityTextbox = By.name("city");
	By stateTextbox = By.name("state");
	By pinTextbox = By.name("pinno");
	By phoneTextbox = By.name("telephoneno");
	By emailTextbox = By.name("emailid");
	By passwordTextbox = By.name("password");

	@BeforeClass
	public void beforeClass() {
		// Mo trinh duyet firefox
		driver = new FirefoxDriver();
		// cho cho tim element 30s ( cho tat ca element)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Mo maximize cua so firefox
		driver.manage().window().maximize();
		// tao bo du lieu
		name = "toai phan";
		gender = "male";
		dateOfBirth = "1995-08-06";
		address = "59 DinhThon\nMyDinh\nHaNoi";
		city = "Hanoi";
		state = "VietNam";
		pin = "232455";
		phone = "0342784232";
		// su dung ham random de tao cac email khac nhau
		email = "toaiphan" + randomNumber() + "@gmail.com";

		// mo URL ben duoi
		driver.get("http://demo.guru99.com/v4");
		// gan URL vao 1 loginPage URL de khi URL thay doi se khong phai sua code
		loginPageURL = driver.getCurrentUrl();
	}

	@Test
	public void TC_01_Register() {
		// click to 'Here' Link ( co href va text) => dung xpath voi text
		driver.findElement(By.xpath("//a[text()='here']")).click();
		// Input to Email ID textbox ( uu tien name)
		driver.findElement(By.name("emailid")).sendKeys(email);
		// Click to submit button
		driver.findElement(By.name("btnLogin")).click();
		// get userID/ PW value bang quan he anh em
		userIDValue = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

	}

	@Test
	public void TC_02_Login() {
		// mo lai URL de dang nhap
		driver.get(loginPageURL);
		// input userid/password
		driver.findElement(By.name("uid")).sendKeys(userIDValue);
		driver.findElement(By.name("password")).sendKeys(password);
		// Click to submit button
		driver.findElement(By.name("btnLogin")).click();
		// verify da dang nhap thanh cong
		Assert.assertEquals(driver.findElement(By.className("heading3")).getText(),
				"Welcome To Manager's Page of Guru99 Bank");

	}

	@Test
	public void TC_03_New_Customer() {
		// click to New customer

		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		// INPUT du lieu
		driver.findElement(customerNameTextbox).sendKeys(name);
		driver.findElement(dateOfBirthTextbox).sendKeys(dateOfBirth);
		driver.findElement(addressTextArea).sendKeys(address);
		driver.findElement(cityTextbox).sendKeys(city);
		driver.findElement(stateTextbox).sendKeys(state);
		driver.findElement(pinTextbox).sendKeys(pin);
		driver.findElement(phoneTextbox).sendKeys(phone);
		driver.findElement(emailTextbox).sendKeys(email);
		driver.findElement(passwordTextbox).sendKeys(password);
		// Click to submit button
		driver.findElement(By.name("sub")).click();
		// verify da tao khach hang moi thanh cong
		Assert.assertEquals(driver.findElement(By.className("heading3")).getText(),
				"Customer Registered Successfully!!!");
		// verify data input voi data server tra ve
		Assert.assertEquals(
				driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(),
				gender);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(),
				dateOfBirth);
		// do du lieu output ko xuong dong, nen can chuyen address ve ko xuong dong
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),
				address.replace("\n", " "));
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),
				state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),
				phone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),
				email);
		//get customer ID
		customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
	}

	@Test
	public void TC_04_Edit_Customer() {
		// click to Edit Customer

		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		//Input to customer ID text box
		driver.findElement(By.name("cusid")).sendKeys(customerID);
		//click submit
		driver.findElement(By.name("AccSubmit")).click();
		
		//1h38 [Online 16] - Topic 13 (Handle Textbox/ TextArea)

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	// ham random
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
