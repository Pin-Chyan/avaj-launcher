package flyables;

import weather.*;

public class Helicopter extends Aircraft {
	private WeatherTower subWeatherTower;

	Helicopter(final String name, final Coords coords) {
		super(name, coords); // Parenting of Aircraft
	}

	public void updateConditions() {
		String weather = subWeatherTower.getWeather(this.coords);
		System.out.println("here");
		Coords craft = Helicopter.this.coords;
		switch(weather) {
			case "RAIN":
				Helicopter.this.coords.setLongitude(craft.getLongitude() + 5);
				System.out.println("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Rain detected nothing to be wary about.");
				break;
			case "FOG":
				Helicopter.this.coords.setLongitude(craft.getLongitude() + 1);
				System.out.println("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Fog detected beware of surroundings.");
				break;
			case "SUN":
				Helicopter.this.coords.setLongitude(craft.getLongitude() + 10);
				Helicopter.this.coords.setHeight(craft.getHeight() + 2);
				System.out.println("Helicopter#" + name + "(" + Helicopter.this.id + ")" + ": Sun Shine time to search for some new islands.");
				break;
			case "SNOW":
				Helicopter.this.coords.setLatitude(craft.getHeight() - 12);
				System.out.println("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Snow Storm around the area a.k.a blizzard.");
				break;
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.subWeatherTower = weatherTower;
	}
}