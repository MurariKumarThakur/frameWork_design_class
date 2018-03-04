package dummyclassmethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/java/com/testData/TestData.xlsx");
	Workbook workbook =	WorkbookFactory.create(fis);
	Sheet sheet =  workbook.getSheet("Sheet1");
	
	System.out.println(sheet.getLastRowNum());
	
	for(int i=0 ;i<=sheet.getLastRowNum();i++){
		
		Row row =sheet.getRow(i);
		System.out.println(row.getLastCellNum());
		for(int j=0;j<row.getLastCellNum();j++){
			
			Cell cell = row.getCell(j);
			String data = cell.getStringCellValue();
			System.out.println("excel data is======= "+data);	
		}
		
	}
	
	
	}

}
