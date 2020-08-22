package flyables;

import weather.WeatherTower;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower); // not implemented yet uml diagram
}