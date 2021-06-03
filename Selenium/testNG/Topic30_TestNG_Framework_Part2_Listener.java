package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterClass;

@Listeners(testNG.TestNGListener.class)
public class Topic30_TestNG_Framework_Part2_Listener {

	@Test()
	// neu test case xay ra fail,pass,... thi se co hanh dong nhu trong
	// TestNGListenner da dinh nghia
	// vi du fail thi chup man hinh, add vao report
	public void TC_01() {
		System.out.println("run_TC01");
	}

	public void TC_02() {
		System.out.println("run_tc02");
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
