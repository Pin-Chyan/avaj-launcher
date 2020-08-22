package flyables;

import weather.*;

public class Jetplane extends Aircraft {
	private WeatherTower subWeatherTower;

	Jetplane(final String name, final Coords coords) {
		super(name, coords); // Parenting of Aircraft
	}

	public void updateConditions() {
		final String weather = subWeatherTower.getWeather(this.coords);
		Coords craft = Jetplane.this.coords;
		switch(weather) {
			case "RAIN":
				Jetplane.this.coords.setLatitude(craft.getLatitude() + 5);
				System.out.println("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Heavy rain ahead beware of engine flameout.");
				break;
			case "FOG":
				Jetplane.this.coords.setLatitude(craft.getLatitude() + 1);
				System.out.println("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Fog appearing ahead keep safe distances between other planes if spotted.");
				break;
			case "SUN":
				Jetplane.this.coords.setLatitude(craft.getLatitude() + 10);
				Jetplane.this.coords.setHeight(craft.getHeight() + 2);
				System.out.println("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Sun eclipse is appearing enjoy the moment.");
				break;
			case "SNOW":
				Jetplane.this.coords.setLatitude(craft.getHeight() - 7);
				System.out.println("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Snowfall ahead beware of blizzards around the area.");
				break;
		}
	}
	public void registerTower(WeatherTower weatherTower) {
		this.subWeatherTower = weatherTower;
	}
}