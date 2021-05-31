package ApacheTest.APACHEPOI;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends AditiTestData {


	public static void main(String args[])throws InterruptedException, IOException {

		Sheet sheet1 = EstablishConnection("./ApacheTest.xlsx", "cred");
		ArrayList<String> list2;

		WebDriver driver=getdriver("https://www.facebook.com/");

		list2 = getRow(sheet1);
		for (String s : list2) 
		{
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys(s.split(",")[0]);
			driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(s.split(",")[1]);
			Thread.sleep(2000);
			driver.findElement(By.name("login")).click();
			driver.navigate().refresh();
			String hometitle = driver.getTitle();
			

			if (hometitle.equals("Facebook"))
			{

				System.out.println(s+": Valid credentials");
				driver.close();
				driver = new FirefoxDriver();
				driver.get("https://www.facebook.com/");
			} 
			else 
			{
				System.out.println(s+": Invalid credentials");
				driver.findElement(By.xpath("//*[@id='email']")).clear();
				driver.findElement(By.xpath("//*[@id='pass']")).clear();
			}
			

		}

		driver.close();
	}

}
