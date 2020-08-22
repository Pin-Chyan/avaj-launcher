package weather;

//import flyables.Coords;

//import java.util.concurrent.ThreadLocalRandom;

import flyables.Coords;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG" , "SUN", "SNOW"};

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	//testing for heli
	public static String getCurrentWeather(Coords coords) { // Weather gen

		int low = 1;
		int high = 5;
		int con = 0;
		while (coords.getHeight() <= 100) {
			if (con == 3) {
				con = 0;
			}
			if (coords.getHeight() >= low && coords.getHeight() <= high) {
				return weather[con];
			}
			low = low + 5;
			high = high + 5;
			con++;
		}
		return weather[0];
	}

}