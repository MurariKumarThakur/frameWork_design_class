package com.object.utility;

import java.io.IOException;

import com.file.utility.excelFileReusable;
import com.file.utility.propertyFileReusable;
import com.file.utility.textFileReusable;



public class objectUtility {
	
private String filePath;	
private static excelFileReusable  excelReusable ;	
private static textFileReusable    textReusable ;
private static propertyFileReusable config; 
private static propertyFileReusable gmailLoc;

private static String excelFilePath = "./src/test/java/com/testData/TestData.xlsx";
private static String textFilePath = "./src/test/java/TextFileFolder/textFile.txt";
private static String configfilePath = "./config.property";
private static String gmailfilePath = "./src/test/java/com/app/objectRepository/OR.gamil.properties";


static public excelFileReusable getExcelReusable(String filePath) {
	excelReusable = new excelFileReusable(filePath);
	return excelReusable;
}
static public textFileReusable getTextReusable(String filePath) {
	try {
		textReusable = new textFileReusable(filePath);
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
	}
	return textReusable;
}
static public propertyFileReusable getConfig(String filePath) {
	config = new propertyFileReusable(filePath);
	return config;
}
static public propertyFileReusable gmailLoc(String filePath) {
	gmailLoc = new propertyFileReusable(filePath);
	return gmailLoc;
}




public static String getExcelFilePath() {
	return excelFilePath;
}
public static String getTextFilePath() {
	return textFilePath;
}
public static String getConfigfilePath() {
	return configfilePath;
}
public static String getGmailfilePath() {
	return gmailfilePath;
}





	

	

}
