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
    
	public WeatherInfo() {
		loadData(csvFile);
	}
	@Override
	public void loadData(String filePath) {
		//initialize the BufferedReader variable
	 	// in future versions we can initialize here from other methods(readFromJson,readFromWebService)
	 	BufferedReader buf_reader = Utilities.readFromCSV(csvFile);
	 	
	 	// Convert the BufferedReader to ArrayList and Store it.
	 	// All methods in this class will get the values from the ArrayList<String> weatherValues
	 	weatherValues = Utilities.bufferedReaderToArrayList(buf_reader,true);
	}
	@Override
	public String getSmallestTempSpread() {
		// TODO Auto-generated method stub
		return null;
	}

}
