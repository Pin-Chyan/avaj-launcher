package flyables;

public class Aircraft {
	protected long id;
	protected String name;
	protected Coords coords;
	private long idCounter = 0L;

	protected Aircraft(String name, Coords coords) {
		this.name = name;
		this.coords = coords;
		this.idCounter = nextId();
		this.id = this.idCounter;
		//System.out.println(this.name);
	}

	private long nextId() {
		return ++idCounter;
	}


}