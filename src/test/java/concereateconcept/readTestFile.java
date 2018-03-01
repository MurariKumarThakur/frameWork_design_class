package concereateconcept;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class readTestFile {
	
	
	/*
	 * @Author 
	 * Murari
	 * 
	 * purpose of this class
	 * 
	 * 1.
	 * 
	 * 
	 */
	
	

	public static  void main(String[] args) throws IOException {
		
		
		File file = new File ("./src/test/java/TextFileFolder/textFile.txt");
	  boolean b = 	  file.createNewFile();
	    if(b==true){
	    
	    	System.out.println("TEXT FILE CREATED SUCCESSFULLY ");
	     	
	    }else{
	    	
	    	System.out.println("TEXT FILE ALREADY EXIT");
	    }
	    
	 
	         /*
	          * how to write .txt file 
	          * 
	          * FileWriter fw = new FileWriter();
	          * 
	          * BuffterWriter bw = new BufferWriter();
	          * 
	          * bw.write("");
	          * 
	          * bw.flush();
	          * 
	          * 
	          * 
	          */
	    
	    
		           // Read file using this cmd 
	    
		         FileReader fr = new FileReader(file);
		         BufferedReader br = new BufferedReader(fr);
		         
		         
		         
		         
		              br.readLine();
		              br.ready();
		              
		         
		         
		             
		    // for reading  we are doing  br.readLine();
		        
		      
		            System.out.println(br.ready());
		                 
		             int i = 1 ;
		             
		      while (br.ready()){
		    	  
		    String dataLineByLine  =  	  br.readLine();
		    	       System.out.println();
		    	    
		    	       
		    	        if(i==7){
		    	          System.out.println(i);
		    	int x =        	dataLineByLine.length();  
		    	
		    	System.out.println("7th line String total number of count ===="+x);
		    	                	
		    	        }
		    	       
		    	       i++ ;
		      }
		    
		             
		            
		            		 
		                   
		                   
		                   
		
}

}
