package flyables;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		
		Coords coords = new Coords(longitude, latitude, height);
	
		String instance = type.toLowerCase();
		if (instance.equals("helicopter")) {
			return new Helicopter(name, coords);
		} else if (instance.equals("jetplane")) {
			return new Jetplane(name, coords);
		} else if (instance.equals("baloon")) {
			return new Baloon(name, coords);
		} else {
			return null;
		}
	}
}