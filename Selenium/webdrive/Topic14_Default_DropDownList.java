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

public class Topic14_Default_DropDownList {
	WebDriver driver;
// lam viec voi default dropdown  can khai bai select
	Select select;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_Single() {
		driver.get("https://www.facebook.com/");
		// khoi tao 1 bien select: di tim element co id bang day
		select = new Select(driver.findElement(By.id("month")));
		// kiem tra 1 dropdown co ho tro chon nhieu hay ko
		boolean status = select.isMultiple();
		Assert.assertFalse(status);
		// co 3 cach de lua chon 1 item
		// byindex ko nen dung vi neu thay doi thu tu thi se chay sai
		select.selectByIndex(2);
		sleepInSecond(3);
		// kiem tra da chon 1 item thanh cong , get first vi sau khi chon thanh cong
		// item se hien thi len tren cung
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Tháng 2");
		// byvalue co the co nhung ko lien quan den element
		select.selectByValue("5");
		sleepInSecond(3);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Tháng 5");

		// nen su dung Byvisible text
		select.selectByVisibleText("Tháng 10");
		sleepInSecond(3);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Tháng 10");
// kiem tra xem 1 dropdown co bao nhieu item va item cua no la gi
// get ra tat cac the option (item) cua dropdown
		List<WebElement> monthOption = select.getOptions();
//IN ra xem co bao nhieu item
		int monthOptionSize = monthOption.size();
		System.out.println(" so item trong thang la " + monthOptionSize);
// kiem tra so luong item bang bao nhieu ( co dung voi yeu cau ko)
		Assert.assertEquals(monthOptionSize, 13);

// in ra item value cua no la gi ( dung for thuong, hoac for each)
//for iterator
		for (int i = 0; i < monthOption.size(); i++) {

			System.out.println("for iterator" + monthOption.get(i).getText());
		}
//for iterator 5
		for (int i = 0; i < monthOption.size(); i++) {

			System.out.println("for iterator" + monthOption.get(i).getText());
			if (i == 5) {
				break;
			}
		}

// dung for each ( gon gang nhung ko break duoc)
		for (WebElement option : monthOption) {
			System.out.println("for each" + option.getText());
		}
// kiem tra dropdown hien thi dung cac gia tri
// tao ra 1 mang de chua cac item yeu cau
		ArrayList<String> actualItem = new ArrayList<String>();
//add cac item vao mang
		actualItem.add("Tháng");
		actualItem.add("Tháng 1");
		actualItem.add("Tháng 2");
		actualItem.add("Tháng 3");
		actualItem.add("Tháng 4");
		actualItem.add("Tháng 5");
		actualItem.add("Tháng 6");
		actualItem.add("Tháng 7");
		actualItem.add("Tháng 8");
		actualItem.add("Tháng 9");
		actualItem.add("Tháng 10");
		actualItem.add("Tháng 11");
		actualItem.add("Tháng 12");

		ArrayList<String> expectedItem = new ArrayList<String>();

// dung for each de add cac item ma web hien ra
		for (WebElement option : monthOption) {
			expectedItem.add(option.getText());
		}
//verify 2 mang nay
		Assert.assertEquals(expectedItem, actualItem);

	}

	@Test
	public void TC_02_Multiple() {

		driver.get("https://automationfc.github.io/basic-form/index.html");
		select = new Select(driver.findElement(By.xpath("//select[@id='job2']")));
// kiem tra ho tro multiple ko
		Assert.assertTrue(select.isMultiple());
//chon 3 item
		select.selectByVisibleText("Automation");
		select.selectByVisibleText("Mobile");
		select.selectByVisibleText("Perfomance");
// get size : xem da chon bang 3 chua
		int optionSelected = select.getAllSelectedOptions().size();
		System.out.println("item da chon" + optionSelected);
		Assert.assertEquals(optionSelected, 3);
// in ra 3 item da chon o tren
		List<WebElement> optionSelectedElement = select.getAllSelectedOptions();
		for (WebElement option : optionSelectedElement) {
			System.out.println(option.getText());
// bo chon het 3 item da chon va kiem tra xem da bo chua
			select.deselectAll();
			optionSelected = select.getAllSelectedOptions().size();
			Assert.assertEquals(optionSelected, 0);

		}

	}

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
