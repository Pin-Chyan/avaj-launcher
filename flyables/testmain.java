package flyables;

public class testmain {
	public static void main(String[] args) {
		Coords mycoords = new Coords(20,50,75);
		Aircraft plane = new Aircraft("balloon", mycoords);
		System.out.println(plane.name);
		System.out.println(plane.id);
		int longi = mycoords.getLongitude();
		int lati = mycoords.getLatitude();
		int hei = mycoords.getHeight();
		System.out.println("Longitude: " + longi + " Latitude: " + lati + " " + hei);

	}
}