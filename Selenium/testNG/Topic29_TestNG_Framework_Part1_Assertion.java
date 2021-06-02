package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
//2/.assetion
public class Topic29_TestNG_Framework_Part1_Assertion {
	@Test
	public void TC_01() {
		int a = 10;
		int b = 15;
		boolean status = b>a;
		System.out.println(status);
		//kiem tra dieu kien dung
		Assert.assertTrue(status);
		//kiem tra dieu kien sai
		Assert.assertFalse(a>b);
		
		//kiem tra bang nhau khong?
		Assert.assertEquals(a, 10);

	}
}
//3.testNG group : vi du nhu testcase vua cho mobile, vua cho web. minh chi muon chay cho web thi co the gan group name cho testcase
//sau do trong file xml sua thong tin de chay voi group name do
//4. 

//@AfterClass(alwaysRun=true)
//Neu chay nhieu class. before class bi fail , no se bo qua ko chay cac test case va after class. vi du no se mo 100 trinh duyet
// de giai quyet van de tren, cho always run=true vao de luon luon quit trinh duyet

//5. testng priority/ skip tescase : rat it dung
// khi chay testng se chay cac ham @test theo thu tu a,b,c... vi the co the danh priority de chay lan luot
//@Test(priority =1)
//cach nay it dung, nen viet ham ten as TC_01_Creat_User

//skip test case : @test(enabled= false), it dung, nen xoa @test di la xong
//6. tao mieu ta cho test case, cho ng khac su dung de test
//@test(description = "mieu ta testcase"), no se in ra console khi chay