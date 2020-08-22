package flyables;

//import weather.*;

public class testmain {
	public static void main(String[] args) {
		Coords mycoords = new Coords(20,50,11);
		//Aircraft plane = new Aircraft("balloon", mycoords);
		//System.out.println(plane.name);
		//System.out.println(plane.id);
		//int longi = mycoords.getLongitude();
		//int lati = mycoords.getLatitude();
		//int hei = mycoords.getHeight();
		//System.out.println("Longitude: " + longi + " Latitude: " + lati + " " + hei);
		Helicopter heli = new Helicopter("heli", mycoords);
		Baloon ball = new Baloon("baloon", mycoords);
		System.out.println(heli.name);
		//System.out.println(WeatherTower.getWeather());
		//System.out.println(WeatherProvider.getCurrentWeather(mycoords));
		heli.updateConditions();
		ball.updateConditions();
	}
}