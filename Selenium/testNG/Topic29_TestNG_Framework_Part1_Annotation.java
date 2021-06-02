package testNG;

//1.annotation la chi dan cho HAm, vi du ham nao la presetting, ham nao la testcase...
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

// them vao  runTestcase.xml luc tao class de co the chay tu file xml
public class Topic29_TestNG_Framework_Part1_Annotation {
	
//	@BeforeSuite( chay 1 lan)
//		@BeforeTest( chay 1 lan)
				//	@BeforeClass( chay 1 lan)
								//	BeforeMethod ( chay rieng cho tung method)
								//	TC_01 = method
								//	@AfterMethod ( chay rieng cho tung method)
	
	
								//	BeforeMethod( chay rieng cho tung method)
								//	TC_02 = method
								//	@AfterMethod( chay rieng cho tung method)
	
	
								//	BeforeMethod( chay rieng cho tung method)
								//	TC_03 = method
								//	@AfterMethod( chay rieng cho tung method)
	
				//	@AfterClass( chay 1 lan)
	//	@AfterTest( chay 1 lan)
//@AfterSuite( chay 1 lan)
	@Test()
	public void TC_01() {
		System.out.println("TC_01");
	}

	@Test()
	public void TC_02() {
		System.out.println("TC_02");
	}

	@Test()
	public void TC_03() {
		System.out.println("TC_03");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");

	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");

	}

}
