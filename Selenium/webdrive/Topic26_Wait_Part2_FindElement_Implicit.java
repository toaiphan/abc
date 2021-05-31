package webdrive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
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

public class Topic26_Wait_Part2_FindElement_Implicit {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		// implicitly (ngam dinh) wait la ham anh huong truc tiep den 2 ham find
		// element/s, chi wait cho viec di tim element
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://m.facebook.com/");
	}

	// @Test
	// findElement : impicitly cho 10s, cu 0,5s lai tim element 1 lan, tim duoc thi
	// thoi ko wait nua , neu ko tim thay
	// thi se danh fail test case throw ra 1 exception NoSuchElement
	public void TC_01_Find_Element() {

		// 1 element (chi mat khoang 1s)
		System.out.println("1--Start:" + getDateTimeNow());
		driver.findElement(By.id("m_login_email")).sendKeys("toaiphan86@gmai.com");
		System.out.println("1--End:" + getDateTimeNow());

		// >1 element(chi mat khoang 1s)
		System.out.println("2--Start:" + getDateTimeNow());
		driver.findElement(By.xpath("//input[@autocorrect='off']")).sendKeys("toaiphan862@gmai.com");

		System.out.println("2--End:" + getDateTimeNow());

		// 0 element(mat 10s)
		System.out.println("3--Start:" + getDateTimeNow());
		try {

			driver.findElement(By.xpath(".//*[@id='did_submit']")).click();
		} catch (Exception e) {
			System.out.println("3--End:" + getDateTimeNow());
			throw e;
		}

	}

	@Test
	// findElements : impicitly cho 10s, cu 0,5s lai tim element 1 lan, tim duoc thi
	// thoi ko wait nua , neu ko tim thay
	// thi se ko danh fail testcase va throw ra 1 exception NoSuchElement
	public void TC_02_Find_Elements() {
		List<WebElement> elements;
		// 1 element (chi mat khoang 1s)
		System.out.println("1--Start:" + getDateTimeNow());
		elements = driver.findElements(By.id("m_login_email"));
		System.out.println("elements size:" + elements.size());
		System.out.println("1--End:" + getDateTimeNow());

		// >1 element(chi mat khoang 1s)
		System.out.println("2--Start:" + getDateTimeNow());
		elements = driver.findElements(By.xpath("//input[@autocorrect='off']"));
		System.out.println("elements size:" + elements.size());
		System.out.println("2--End:" + getDateTimeNow());

		// 0 element(mat 10s)// khong danh fail test case va ko throw exception, tra ve 1 list rong, neu cta thao tac voi list do, se bi fail
		System.out.println("3--Start:" + getDateTimeNow());

		elements = driver.findElements(By.xpath(".//*[@id='did_submit']"));
		System.out.println("elements size:" + elements.size());
		System.out.println("3--End:" + getDateTimeNow());

	}

// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai exception, chu ko stop cac testcase sau
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

// ham de lay thoi gian hien tai
	public String getDateTimeNow() {
		Date date = new Date();
		return date.toString();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
