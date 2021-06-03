package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

// parameter : la viec 1 TC viet co the chay tren nhieu trinh duyet : firefox,chrome,ie...hoac phan tan cac testcase tren cac may khac nhau
//edit file XML, khi run phai chay tu file xml, no se chay tung trinh duyet mot, moi trinh duyet chay het cac data provider
//cloud testing : browerstack.com, cong ty co tien thi build lab nhieu may tinh , moi may set up san 1 version trinh duyet web
public class Topic30_TestNG_Framework_Part2_Parameter_optional_parallel {
	WebDriver driver;
	String userDirectory =System.getProperty("user.dir");

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider(name = "user_pass")
	public Object[][] UserAndPasswordData() {
		return new Object[][] {
				// mau la ko co "new Object[]" o tung dong
				{ "toaiphan1@gmail.com", "123456" }, // 1
				{ "toaiphan2@gmail.com", "123456" },// 2
		};
	}

	// lay ra browserName tu file XML
	@Parameters("browserName")

	@BeforeClass
	
	// can tai driver cua cac trinh duyet : kiem tra xem trinh duyet version bao nhieu, copy vao file browserDriver
	//edge co 2 loai : edge legacy ( giong ie, chi dung tren window)- ngung sp, edge chromium( chay tren nhieu os)
	// Su dung Optional nhu 1 backup, neu file xml ko tim thay du lieu, thi se chay firefox
	public void beforeClass(@Optional("firefox")String browser) {
		//neu  browser name la firefox thi mo trinh duyet firefox
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", userDirectory+"/browserDriver/chromedriver");
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
			System.setProperty("webdriver.chrome.driver", userDirectory+"/browserDriver/edgedriver");

		} else {

			throw new RuntimeException("Please input your browser name");
		}

	}

	@Test(dataProvider = "user_pass")
	public void TC_01_Login(String username, String password) {

		// Ham login nay se su dung data o @DataProvider, chay thanh 3 testcase
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
//paralell : chay song song tat ca cac trinh duyet cung luc, neu o local thi nen chay lan luot vi chay parallel de fail do cau hinh may, hover..., server thi co the chay parallel vi tren cac may khac nhau ko bi anh huong
// trong file xml: paralell ="tests" thread-count="2" ( day la so luong chay cung luc), chay xong se chay not thang cuoi
}
