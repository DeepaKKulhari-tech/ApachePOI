package ApacheTest.APACHEPOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilityExcel {

	static String username;
	static String password;
	static WebDriver driver;

	public static List<Object[]> EstablishConnection(String filename, String sheetName) throws IOException {

		List<Object[]> list1 = new ArrayList<Object[]>();
		
		FileInputStream fis = new FileInputStream(filename);

		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);	

		Iterator<Row> itr = sheet.iterator();

		while (itr.hasNext()) {

			Row row1 = itr.next();
			Iterator<Cell> rowItr = row1.cellIterator();
			{

				username = rowItr.next().toString();// column 1
				password = rowItr.next().toString(); // column 2
			}
			String cred[] = { username, password };
			list1.add(cred);

		}

		return list1;
	}

}
