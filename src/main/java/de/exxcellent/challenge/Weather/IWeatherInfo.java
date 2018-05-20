/**
 * 
 */
package de.exxcellent.challenge.Weather;

/**
 * @author Eduardo Gonzalez
 * Interface for WeatherInfo classes
 */
public interface IWeatherInfo {
	void loadData(String FilePath);
	String getSmallestTempSpread();
}
