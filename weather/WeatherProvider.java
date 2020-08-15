package weather;

import flyables.Coords;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG" , "SUN", "SNOW"};

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() { //fucking returning value
		return WeatherProvider.weatherProvider;
	}

	public static void getCurrentWeather() { // Coors coords fucking variables intakes done
		int random;
		random = ThreadLocalRandom.current().nextInt(0, 3 + 1);
		System.out.println(weather[random]);
	}

	public static void main(String[] args) {
		getCurrentWeather();
	}
}