package ApacheTest.APACHEPOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AditiTestData {

	static String username;
	static String password;
	static WebDriver driver;

	public static Sheet EstablishConnection(String filename, String sheetName) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream(filename);

	
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		return sheet;
	}

	public static ArrayList<String> getRow(Sheet sheet1) throws IOException {
		String cred;
		ArrayList<String> list1 = new ArrayList<String>();
		Iterator<Row> itr = sheet1.iterator();

		while (itr.hasNext()) {

			Row row1 = itr.next();
			Iterator<Cell> rowItr = row1.cellIterator();
			{

				username = rowItr.next().toString();// column 1
				password = rowItr.next().toString(); // column 2
			}
			cred = username + "," + password;
			list1.add(cred);

		}

		return list1;
	}
	
	public static WebDriver getdriver(String url)
	{
		System.setProperty("webdriver.gecko.driver",
				"D:\\Downloads\\Download C\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.get(url);
		
		return driver;
		
	}
	
	public void waits()
	{
		WebDriverWait w=new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.alertIsPresent());
		
	}

}
