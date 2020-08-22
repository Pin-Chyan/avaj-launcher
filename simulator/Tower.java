package simulator;

import java.util.ArrayList;
import java.util.List;

import flyables.Flyable;

public class Tower {
	private List<Flyable> cruising = new ArrayList<Flyable>();
	private List<Flyable> landed = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (cruising.contains(flyable)) {
			return ;
		}
		cruising.add(flyable);
	}

	public void unregister(Flyable flyable) {
		if (cruising.contains(flyable)) {
			landed.add(flyable); // landed aircrafts
			cruising.remove(flyable); // remove from the cruising list
		}
		return ;
	}

	protected void conditionsChanged() {
		int i;

		i = 0;
		while (i <cruising.size()) {
			cruising.get(i).updateConditions();
			i++;
		}
	}

	public static void main(String[] args) {
		
	}
}