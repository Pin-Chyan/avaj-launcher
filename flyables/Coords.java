package flyables;

public class Coords {
	private int longitude;
	private int latitude;
	private int height;

	Coords(int longitude, int latitude, int height) {
		setLongitude(longitude);
		setLatitude(latitude);
		setHeight(height);
		//System.out.println(this.longitude);
		//System.out.println(this.latitude);
		//System.out.println(this.height);
	}

	public void setLongitude(int longitude) {
		if (0 <= longitude) {
			this.longitude = longitude;
		} else {
			System.out.println("Positive Longitude Coords Only");
		}
	}

	public void setLatitude(int latitude) {
		if (0 <= latitude) {
			this.latitude = latitude;
		} else {
			System.out.println("Positive Latitude Coords Only");
		}
	}

	public void setHeight(int height) {
		if (0 <= height || 100 >= height) {
			this.height = height;
		} else {
			System.out.println("Height Ranging Between 0 - 100 Only");
		}
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}
}