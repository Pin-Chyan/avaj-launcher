package flyables;

public class Aircraft {
	protected long id;
	protected String name;
	protected Coords coords;
	//private static long idCounter = 0L;

	Aircraft(String name, Coords coords) {
		this.name = name;
		this.coords = coords;
		//System.out.println(this.name);
	}


}