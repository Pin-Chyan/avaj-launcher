package flyables;

public class Aircraft {
	protected long id;
	protected String name;
	protected Coords coords;
	private static long idCounter = 0L;

	protected Aircraft(String name, Coords coords) {
		this.name = name;
		this.coords = coords;
		Aircraft.idCounter = nextId();
		this.id = Aircraft.idCounter;
		//System.out.println(this.name);
	}

	private long nextId() {
		return (++idCounter);
	}

}