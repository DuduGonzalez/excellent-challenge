package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class Utilities {
	private Utilities() {
		//not called, prevent this constructor to being called somewhere else in code.
		// Throw an exception if this is ever called
	    throw new AssertionError("Instantiating Utility class");
	}	
	
	/*
	 *  Method to read CSV files
	 *  
	 *  @param filePath the location of the file to read
	 *  @return BufferedReader containing the data from file
	 * */
    public static BufferedReader readFromCSV(String filePath){
        BufferedReader reader = null;
        try {
        	reader = new BufferedReader(new FileReader(filePath));	   
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		return reader;
    } 
    /*
	 *  Method to convert a bufferedReader to an ArrayList<String> class
	 *  
	 *  @param reader to be converted
	 *  @return ArrayList<Sring>  containing the data 
	 * */
    public static ArrayList<String> bufferedReaderToArrayList(BufferedReader reader, Boolean skipHeader){
    	ArrayList<String> arrayList = new ArrayList<String>();    	
    	String line;
	 	try {
	 		if(skipHeader){
	 			reader.readLine();//skip the first line to don't save the header values.	
	 		}	 		
			while((line = reader.readLine()) != null){
				arrayList.add(line);
		 	}
		} catch (IOException e) {
			e.printStackTrace();
		}	 	
	 	return arrayList;
    }
}