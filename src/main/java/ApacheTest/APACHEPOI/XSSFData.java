package ApacheTest.APACHEPOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("./ApacheTest.xlsx");

		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();

		while (itr.hasNext()) 
		{

			Row row = itr.next();
			Iterator<Cell> cellitr = row.cellIterator();
			while (cellitr.hasNext()) 
			{
			
				FetchedData.setCountry(cellitr.next().toString());
				FetchedData.setCode(cellitr.next().toString());
			}
			System.out.println();
			System.out.println("CountryName:"+FetchedData.getCountry());
			System.out.println("CodeName:"+FetchedData.getCode());
			
		}
fis.close();


	}
	
	

}
