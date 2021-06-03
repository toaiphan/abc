package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Topic30_TestNG_Framework_Part2_Dependency{
	
  @Test()
  public void TC_01() {
	  System.out.println("run_TC01");
  }
  
  //NEU tc 01 pass thi moi chay tc02, ko thi skip
  @Test(dependsOnMethods = "TC_01")
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
