package Flyables;

public class Aircraft {
	long id;
	protected String name;
	//Coordinates = coordinates;
	//private static long idCounter;

	Aircraft(String name) {
		this.name = name;
		//System.out.println(this.name);
	}

	public static void main(String[] args) {
		Aircraft plane = new Aircraft("test");
		System.out.println(plane.name);
	}
}