package flyables;

import weather.*;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower subWeatherTower = new WeatherTower();

	Baloon(String name, Coords coords) {
		super(name, coords); // Parenting of Aircraft
	}

	public void updateConditions() {
		String weather = subWeatherTower.getWeather(this.coords);
		Coords craft = Baloon.this.coords;
		switch(weather) {
			case "RAIN":
				Baloon.this.coords.setHeight(craft.getHeight() - 5);
				System.out.println("Baloon#" + name + "(" + Baloon.this.id + ")" +  ": Rain forecast protect thy fire as soon as possible.");
				break;
			case "FOG":
				Baloon.this.coords.setHeight(craft.getHeight() - 3);
				System.out.println("Baloon#" + name + "(" + Baloon.this.id + ")" +  ": Fog forecast you may not have the full experience of the trip/tour.");
				break;
			case "SUN":
				Baloon.this.coords.setLongitude(craft.getLongitude() + 2);
				Baloon.this.coords.setHeight(craft.getHeight() + 4);
				System.out.println("Baloon#" + name + "(" + Baloon.this.id + ")" +  ": Sunny Day enjoy the fantastic view while you can.");
				break;
			case "SNOW":
				Baloon.this.coords.setHeight(craft.getHeight() - 15);
				System.out.println("Baloon#" + name + "(" + Baloon.this.id + ")" +  ": Snow forecast stay close to the fire to keep warmth.");
				break;
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.subWeatherTower = weatherTower;
	}
}