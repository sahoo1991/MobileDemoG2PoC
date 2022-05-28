package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderLogin {
	
	@DataProvider(name = "LoginDataProvider")
	public Object[][] getData() throws FileNotFoundException, IOException{
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("/Users/sangrambadi/Downloads/file_example_XLS_10.xls")));
		XSSFSheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(0);
		for (int i =0; i<row.getLastCellNum(); i ++) {
			System.out.println(row.getCell(i).toString());
		}
		return new Object[][] {};
		
	}

}
