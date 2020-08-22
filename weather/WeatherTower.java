package weather;

import flyables.Coords;
import simulator.Tower;

public class WeatherTower extends Tower {

	public String getWeather(Coords coords) {
		return WeatherProvider.getProvider().getCurrentWeather(coords);
	}

	void changeWeather() {
		this.conditionsChanged();
	}
}