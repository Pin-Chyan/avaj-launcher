package flyables;

import weather.*;

public class Baloon extends Aircraft {
	Baloon(final String name, final Coords coords) {
		super(name, coords); // Parenting of Aircraft
	}

	public void updateConditions() {
		String weather = (WeatherProvider.getCurrentWeather());
		switch(weather) {
			case "RAIN":
				System.out.println("Heavy Storms Ahead");
				break;
			case "FOG":
				System.out.println("FOG YOU SHALL NOT PASS");
				break;
			case "SUN":
				System.out.println("FEEL THE BURN");
				break;
			case "SNOW":
				System.out.println("ITS SNOWING");
				break;
		}
	}
}