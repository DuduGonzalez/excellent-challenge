package de.exxcellent.challenge.Football;

import java.io.BufferedReader;
import java.util.ArrayList;

import de.exxcellent.challenge.Utilities;

public class FootballInfo implements IFootballInfo {
	private ArrayList<String> footballValues;
    private String csvSplitBy = ",";
	private static String csvFile = "src/main/resources/de/exxcellent/challenge/football.csv";
    
	public FootballInfo() {
		this(csvFile);
	}
	public FootballInfo(String filePath) {
		loadData(filePath);
	}
	@Override
	public void loadData(String FilePath) {
		//initialize the BufferedReader variable
	 	// in future versions we can initialize here from other methods(readFromJson,readFromWebService)
	 	BufferedReader buf_reader = Utilities.readFromCSV(csvFile);
	 	
	 	// Convert the BufferedReader to ArrayList and Store it.
	 	// All methods in this class will get the values from the ArrayList<String> footballValues
	 	footballValues = Utilities.bufferedReaderToArrayList(buf_reader,true);
	}

	/*
	 *  Return the team which has the smallest difference between goals and  goals allowed
	 *  
	 *  @return String that indicates the team.
	 * */
	@Override
	public String getSmallestGoalDistance() {
		double minDifference = Double.POSITIVE_INFINITY;
	 	String team = null;		 		   
	 	try {
	 		for(String v : footballValues) {
		    	String newLine = v;
		    	// use the character to separate the values of the element
	            String[] values = newLine.split(csvSplitBy);
	            //compare the maximum and the minimum and store always the small Abs difference
	            double dif = Math.abs(Double.parseDouble(values[5]) - Double.parseDouble(values[6]));
	           if(dif < minDifference){
	        	   minDifference = dif;
	        	   team = values[0];
	           }
		     }
		} catch (Exception e) {
			e.printStackTrace();
		}	    
	    return team;
	}

}
