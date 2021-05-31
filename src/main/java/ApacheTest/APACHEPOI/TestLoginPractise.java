package ApacheTest.APACHEPOI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestLoginPractise extends utilityExcel {
	static WebDriver driver;

	@DataProvider
	public Iterator<Object[]> getData() throws InterruptedException, IOException {

		List<Object[]> list2= EstablishConnection("./ApacheTest.xlsx", "cred");
		return list2.iterator();

	}

	@Test(dataProvider = "getData")
	public static void loginTest(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
		driver.navigate().refresh();
		String hometitle = driver.getTitle();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(hometitle, "Facebook");
		softAssert.assertAll();
		
		

	}

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\Downloads\\Download C\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");

	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
