package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Topic30_TestNG_Framework_Part2_Loop_multi_suite{
	//chay 10 lan 1 testcase
  @Test(invocationCount = 10)
  public void f() {
	  System.out.println("run");
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
//Run multi suite in testNG : tao 1 file xml , sau do chay theo cac file xml multil ( xem phan cuoi file xml)
//cach khac de chay tat ca cac tc , chay theo package