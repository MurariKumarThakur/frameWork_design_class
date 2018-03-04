package com.file.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class propertyFileReusable  {
	 private FileInputStream fis ;
	  Properties property = new Properties ();
	         String filePath ;
	         String value ;
	public propertyFileReusable(String filePath) {
	
		 this.filePath = filePath;
		
	  FileInputStream fis;
	try {
		fis = new FileInputStream(filePath);
	  	if(fis !=null){
		    try {
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   	}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
		 
	}
     public String getPropertyFileValue(String enterKey){
    	 
    	String value =   property.getProperty(enterKey);
    	    if(value != null){
    	       return value ;
    	    }else{
    	    	System.out.println("KEY IS HOLDING  null VALUE");
    	    }return "PLEASE CHECK ENTERED KEY";
     }
     
     public void SetProperty(String enterKey , String enterValue) throws FileNotFoundException, IOException{
    	
    	  property.setProperty(enterKey, enterValue);
    	  property.store(new FileOutputStream(filePath), "VALUE ADDED IN PROPERTIES FILE");
    	 
     }
     public  Map getAllPropertyData(){
    	 Map  map = new LinkedHashMap();
    	  if(property!=null){
    		
          Set keys = property.keySet();
                
            for(Object data:keys){
            	
            	 String keydata =     (String) data;
            	 
            	
            	 
            	 String value = property.getProperty(keydata);
            	 
         	    map.put(keydata, value);
        
              
            	
            }
          
            
    		  
    	  }
		return map;
	
    	 
    	 
    	 
     }
   
}

