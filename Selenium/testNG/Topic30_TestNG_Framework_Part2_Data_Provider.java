package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

// xay dung 1 bo data va chay qua lan luot cac data trong do . Vi du nhu dang nhap 100 acc
public class Topic30_TestNG_Framework_Part2_Data_Provider {
	@Test(dataProvider = "user_pass")
	public void TC_01_Login(String username, String password) {

		// Ham login nay se su dung data o @DataProvider, chay thanh 3 testcase
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

//TH1: xay dung 1 bo data chi cho 1 method
	@DataProvider(name = "user_pass")
	public Object[][] UserAndPasswordData() {
		return new Object[][] {
				// mau la ko co "new Object[]" o tung dong
				{ "toaiphan1@gmail.com", "123456" }, // 1
				{ "toaiphan2@gmail.com", "123456" },// 2
		};
	}
// TH2,// truong hop 1 data su dung cho 2 method thi dung ham nay
	//no se chay login 3 tc, xong moi chay register 3 TC. xong thang nao thi xong ca bo data luon
	@DataProvider(name = "register_login")
	// truong hop 1 data su dung cho 2 method thi dung ham nay
	// method su dung thu vien cua java reflex
	public Object[][] registerAndLogin(Method methodName) {
		Object[][] result = null;
		{
			// Neu methodName co chua login thi su dung bo data nay
			if (methodName.getName().contains("Login")) {
				return new Object[][] { 
					{ "toaiphan1@gmail.com", "123456" }, // 1
						{ "toaiphan2@gmail.com", "123456" },// 2
				};
			}
			//Neu methodName co chua register thi su dung bo data nay
			else if(methodName.getName().contains("Register"))
				return new Object[][] { 
				{ "toaiphan1@gmail.com", "abc123" }, // 1
						{ "toaiphan2@gmail.com", "abcq12" },// 2
				};
		}
		return result;
	}
	//TH3: ket hop excel ,google search dataprovider +testNG+excel

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
