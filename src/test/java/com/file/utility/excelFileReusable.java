package com.file.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelFileReusable {
	
	  String filePath ;
	 FileInputStream fis;
	 Workbook workbook ;
	 Sheet sheet;
	 Row row ;
	 Cell cell;
	 String  cellValue ;
	 List allCellValue ;
	public excelFileReusable(String filePath){
		
		this.filePath= filePath;
		
		try {
			fis = new FileInputStream(filePath);
			workbook =		WorkbookFactory.create(fis);
			
		} catch (Exception e) {
			 System.out.println("Path Not mantaion "+e.getMessage());
		}
 
	}
	public Sheet getSheet (String sheetName){
		    Sheet  sheet = null ;
		   if(workbook!=null){
		  sheet = workbook.getSheet(sheetName);
		  
		   }
		   return sheet ;
		
		
		
	}
  public Sheet getSheetAt(int sheetIndex){
	
	  Sheet sheet = null ;
	  
	    if(workbook!=null){
	    	
	    	 sheet = workbook.getSheetAt(sheetIndex);
	    }
	  return sheet ;
	  
  }
  public Row  getRow(String sheetName,int rowNum){
	  Row row = null ;
	  getSheet(sheetName);
	 
	   if(sheet!=null){
		 row = sheet.getRow(rowNum); 
		   
	   }
	  return row ;
	  
  }
  public Cell getCell(String sheetName ,int rowNum , int cellNum){
	  
	return    getSheet(sheetName).getRow(rowNum).getCell(cellNum);
	  
	  
	  
  }
  
  public String  getSingleExcelCellValue (String sheetName,int rowNum , int cellNum){
	  
      	cell =  getCell(sheetName, rowNum, cellNum);
      	
      	 if(cell.getCellType()==Cell.CELL_TYPE_STRING){
      		 
      		 cellValue =  cell.getStringCellValue();
      	 }else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
      		 
      		cellValue =  cell.getNumericCellValue()+""; 
      	 }
      	return cellValue ;
  } 
  
    public List getAllExcelCellValue (String sheetName){
    	
    	   sheet =   getSheet(sheetName);
    	  List list = new ArrayList ();
    	    System.out.println(sheet.getLastRowNum());
    	  for (int i = 0 ; i<=sheet.getLastRowNum();i++){
    		  
    		 row =    sheet.getRow(i);
    		    
    		    for(int j =0 ; j<row.getLastCellNum();j++){
    		    	
    		       cell =      row.getCell(j);
    		   
    		   if(cell.getCellType()==Cell.CELL_TYPE_STRING){
    	      		 
    	      		cellValue =  cell.getStringCellValue();
    	      		list.add(cellValue);
    	      	 }else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
    	      		 
    	      		cellValue =  cell.getNumericCellValue()+""; 
    	      		list.add(cellValue);
    	      	 }
    		    }
    	  }
    	return list ;
    }
       public static void main(String[] args) {
    	   
    	   excelFileReusable read = new excelFileReusable("./src/test/java/com/testData/TestData.xlsx");
    	  // String cell2 = read.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
    	// String   cell  = read.getCell("Sheet1", 0, 0).getStringCellValue();
    	  
         System.out.println(read.getAllExcelCellValue("Sheet1"));
		
	}
}
