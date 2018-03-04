package dummyclassmethod;

import java.io.IOException;
import java.util.Map;

import com.file.utility.excelFileReusable;
import com.file.utility.propertyFileReusable;

public class class1 {

	public static void main(String[] args) throws IOException {
		
	excelFileReusable read = new excelFileReusable("./src/test/java/com/testData/TestData.xlsx");
	
	
	


 String cell = read.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
 
 System.out.println(cell);
 
    
	 


	
	}

}
