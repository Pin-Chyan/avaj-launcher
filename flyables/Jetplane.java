package flyables;

import simulator.WriteFile;
import weather.*;

public class Jetplane extends Aircraft implements Flyable {
	private WeatherTower subWeatherTower = new WeatherTower();

	Jetplane(String name,Coords coords) {
		super(name, coords); // Parenting of Aircraft
	}

	public void updateConditions() {
		String weather = subWeatherTower.getWeather(this.coords);
		Coords craft = Jetplane.this.coords;
		switch(weather) {
			case "RAIN":
				Jetplane.this.coords.setLatitude(craft.getLatitude() + 5);
				//System.out.println("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Heavy rain ahead beware of engine flameout.");
				WriteFile.writeF("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Heavy rain ahead beware of engine flameout.");
				break;
			case "FOG":
				Jetplane.this.coords.setLatitude(craft.getLatitude() + 1);
				//System.out.println("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Fog appearing ahead keep safe distances between other planes if spotted.");
				WriteFile.writeF("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Fog appearing ahead keep safe distances between other planes if spotted.");
				break;
			case "SUN":
				Jetplane.this.coords.setLatitude(craft.getLatitude() + 10);
				Jetplane.this.coords.setHeight(craft.getHeight() + 2);
				//System.out.println("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Sun eclipse is appearing enjoy the moment.");
				WriteFile.writeF("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Sun eclipse is appearing enjoy the moment.");
				break;
			case "SNOW":
				Jetplane.this.coords.setLatitude(craft.getHeight() - 7);
				//System.out.println("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Snowfall ahead beware of blizzards around the area.");
				WriteFile.writeF("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Snowfall ahead beware of blizzards around the area.");
				break;
		}
		if (this.coords.getHeight() <= 0) {
			//System.out.println("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Is now Landed.");
			WriteFile.writeF("JetPlane#" + name + "(" + Jetplane.this.id + ")" +  ": Is now Landed.");
			this.subWeatherTower.unregister(this);
			//System.out.println("Tower says: JetPlane#" + name + "(" + Jetplane.this.id + ")" + " unregistered to weather tower.");
			WriteFile.writeF("Tower says: JetPlane#" + name + "(" + Jetplane.this.id + ")" + " unregistered to weather tower.");
		}
	}
	public void registerTower(WeatherTower weatherTower) {
		this.subWeatherTower = weatherTower;
		this.subWeatherTower.register(this);
		//System.out.println("Tower says: JetPlane#" + name + "(" + Jetplane.this.id + ")" + " registered to weather tower.");
		WriteFile.writeF("Tower says: JetPlane#" + name + "(" + Jetplane.this.id + ")" + " registered to weather tower.");
	}
}