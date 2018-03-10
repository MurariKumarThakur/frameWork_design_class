package dummyclassmethod;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel_Reusable {
	String filePath = "./src/test/java/com/testData/TestData.xlsx";
	File file  ;

	FileInputStream fis  ;
	 Workbook workbook ;
	static public  Sheet sheet;
	
	
	public int  getRowNum (String sheetName){
		
		 file = new File(filePath);
		 try{
			fis = new FileInputStream(file);
  workbook =         WorkbookFactory.create(fis);
  
          Sheet sheet =workbook.getSheet(sheetName);
          
            int rowNum = sheet.getLastRowNum();
          
          return  rowNum ;
		
		 }catch(Exception e)	{
			 
			 System.out.println(e.getMessage());
		 }return (Integer) null ;
	}
	
	
	public String getCellData(String sheetName, String colName, int rowNum) {
		
	
		
			try {
				getRowNum(sheetName);
			
				int col_Num = 0;
				
				
			     Row row = sheet.getRow(0);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					if (row.getCell(i).getStringCellValue().equals(colName)) {
						col_Num = i;
						
						row = sheet.getRow(rowNum);
						Cell cell = row.getCell(col_Num);
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								
								//System.out.println(cell.getStringCellValue());
								return cell.getStringCellValue();
							} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								return String.valueOf(cell.getNumericCellValue());
							} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
								return String.valueOf(cell.getBooleanCellValue());
							} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
								return "";
							}

					}else{
						System.out.println("CHECK NAME NOT MATCHING ");
					}
				}
		
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
		
	
	
	

	
	
	public static void main(String[] args) {
		
		excel_Reusable obj = new excel_Reusable();
		
	//	for(int m =1 ; m<= sheet.getLastRowNum();m++){
		
		obj.getCellData("Sheet1", "Name", 1);
		obj.getCellData("Sheet1", "Tools", 1);
	//}
	}

}
