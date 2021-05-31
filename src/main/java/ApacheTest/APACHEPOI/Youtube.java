package ApacheTest.APACHEPOI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Youtube {
	
	@Test
	public static void getdriver() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver",
				"D:\\Downloads\\Download C\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
	
		
		driver.get("https://www.youtube.com/");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement element=driver.findElement(By.id("search"));
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		driver.findElement(By.id("search")).sendKeys("Selenium");
		Thread.sleep(2000);
		driver.findElement(By.id("search-icon-legacy")).click();
		
		Assert.assertEquals(driver.getTitle(), "Selenium");
		
		
		
		
	}

}
