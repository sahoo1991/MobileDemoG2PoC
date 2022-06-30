package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvier {


	@DataProvider(name = "LoginDataProvider")
	public Object[][] getExcelRowData() throws FileNotFoundException, IOException {

		File f = new File("src/test/resources/testData");
		File fs = new File(f, "testData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(fs.getAbsolutePath())));

		Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int colIndex = sheet.getRow(0).getLastCellNum();
		Object ob[][] = new Object[row][colIndex];
		for (int i = 1; i< row+1; i++) {

			Row ro = sheet.getRow(i);

			for(int j = 0; j<ro.getLastCellNum(); j++) {
				ob[i-1][j] = ro.getCell(j).toString();
			}

		}
		wb.close();
		return ob;
	}

	}


