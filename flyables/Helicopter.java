package flyables;

import simulator.WriteFile;
import weather.*;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower subWeatherTower = new WeatherTower();

	Helicopter(String name, Coords coords) {
		super(name, coords); // Parenting of Aircraft
	}

	public void updateConditions() {
		//System.out.println(subWeatherTower.getWeather(coords));
		String weather = this.subWeatherTower.getWeather(this.coords);
		Coords craft = Helicopter.this.coords;
		switch(weather) {
			case "RAIN":
				Helicopter.this.coords.setLongitude(craft.getLongitude() + 5);
				//System.out.println("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Rain detected nothing to be wary about.");
				WriteFile.writeF("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Rain detected nothing to be wary about.");
				break;
			case "FOG":
				Helicopter.this.coords.setLongitude(craft.getLongitude() + 1);
				//System.out.println("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Fog detected beware of surroundings.");
				WriteFile.writeF("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Fog detected beware of surroundings.");
				break;
			case "SUN":
				Helicopter.this.coords.setLongitude(craft.getLongitude() + 10);
				Helicopter.this.coords.setHeight(craft.getHeight() + 2);
				//System.out.println("Helicopter#" + name + "(" + Helicopter.this.id + ")" + ": Sun Shine time to search for some new islands.");
				WriteFile.writeF("Helicopter#" + name + "(" + Helicopter.this.id + ")" + ": Sun Shine time to search for some new islands.");
				break;
			case "SNOW":
				Helicopter.this.coords.setLatitude(craft.getHeight() - 12);
				//System.out.println("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Snow Storm around the area a.k.a blizzard.");
				WriteFile.writeF("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Snow Storm around the area a.k.a blizzard.");
				break;
		}
		if (this.coords.getHeight() <= 0) {
			//System.out.println("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Is now landing.");
			WriteFile.writeF("Helicopter#" + name + "(" + Helicopter.this.id + ")" +  ": Is now landing.");
			this.subWeatherTower.unregister(this);
			//System.out.println("Tower says: Helicopter#" + name + "(" + Helicopter.this.id + ")" + " unregistered to weather tower.");
			WriteFile.writeF("Tower says: Helicopter#" + name + "(" + Helicopter.this.id + ")" + " unregistered to weather tower.");
		}
	}
		
	public void registerTower(WeatherTower weatherTower) {
		this.subWeatherTower = weatherTower;
		this.subWeatherTower.register(this);
		//System.out.println("Tower says: Helicopter#" + name + "(" + Helicopter.this.id + ")" + " registered to weather tower.");
		WriteFile.writeF("Tower says: Helicopter#" + name + "(" + Helicopter.this.id + ")" + " registered to weather tower.");
	}
}