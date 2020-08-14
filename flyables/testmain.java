package flyables;

public class testmain {
	public static void main(String[] args) {
		Coords mycoords = new Coords(100,100,100);
		Aircraft plane = new Aircraft("balloon", mycoords);
		System.out.println(plane.name);
		//int longi = getLongitude();

	}
}