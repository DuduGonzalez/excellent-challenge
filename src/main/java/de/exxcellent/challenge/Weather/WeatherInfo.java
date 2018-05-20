package de.exxcellent.challenge.Weather;

import java.io.BufferedReader;
import java.util.ArrayList;

import de.exxcellent.challenge.Utilities;

/**
 * @author Eduardo Gonzalez
 * Class that loads Weather data and show the day with smallest temperature spread
 */
public class WeatherInfo implements IWeatherInfo {
	private ArrayList<String> weatherValues;
	private static String csvFile = "src/main/resources/de/exxcellent/challenge/weather.csv";
	private static final String cvsSplitBy = ",";
    
	public WeatherInfo() {
		loadData(csvFile);
	}
	/*
	 *  Read the data and store it in parameter weatherValues
	 *  
	 *  @parameter filePath path where the file is stored.
	 * */
	@Override
	public void loadData(String filePath) {
		//initialize the BufferedReader variable
	 	// in future versions we can initialize here from other methods(readFromJson,readFromWebService)
	 	BufferedReader buf_reader = Utilities.readFromCSV(csvFile);
	 	
	 	// Convert the BufferedReader to ArrayList and Store it.
	 	// All methods in this class will get the values from the ArrayList<String> weatherValues
	 	weatherValues = Utilities.bufferedReaderToArrayList(buf_reader,true);
	}
	
	/*
	 *  Return the day with the smallest temperature spread in the loaded data.
	 *  
	 *  @return String that indicates the day.
	 * */
	@Override
	public String getSmallestTempSpread() {
		double minDifference = Double.POSITIVE_INFINITY;
	 	String day = null; 		   
	    for(String val : weatherValues) {
	    	String newLine = val;
	    	// use the character to separate the values of the element
            String[] values = newLine.split(cvsSplitBy);
            //compare the maximum and the minimum and store always the last biggest value
            double dif = Double.parseDouble(values[1]) - Double.parseDouble(values[2]);
           if(dif < minDifference){
        	   minDifference = dif;
        	   day = values[0];
           }
	     }
	    return day;
	}

}
