package de.exxcellent.challenge;

import de.exxcellent.challenge.Football.FootballInfo;
import de.exxcellent.challenge.Weather.WeatherInfo;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

    	WeatherInfo weatherInfo = new WeatherInfo();
    	FootballInfo footballInfo = new FootballInfo();

        String dayWithSmallestTempSpread = weatherInfo.getSmallestTempSpread();
        String teamWithSmallesGoalSpread = footballInfo.getSmallestGoalDistance();

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
