package simulator;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;

import flyables.*;
import weather.*;

import java.util.ArrayList;

public class reader {
	private static WeatherTower subWeatherTower = new WeatherTower();
	private static List<Flyable> flyables = new ArrayList<Flyable>();
	
	private static List<String> readFile(final String filename){
		final List<String> records = new ArrayList<String>();
		try {
	    	final BufferedReader reader = new BufferedReader(new FileReader(filename));
	    	String line;
	    	while ((line = reader.readLine()) != null) {
	    		records.add(line);
	    	}
	    	reader.close();
	    	return records;
	  	}
	  	catch (final Exception e) {
	    	System.err.format("Exception occurred trying to read '%s'.", filename);
	    	e.printStackTrace();
	    	return null;
		}
	}
	
	public static void main(final String[] args) {
		WriteFile.fileCreate();
		WriteFile.getFile();
		String filename = "scenario_1.txt";
		List<String> str = readFile(filename);
		int i = 1;
		String craft;
		String[] craftsplit;
		System.out.println("---List---");
		System.out.println(str);
		System.out.println("---Weather---");
		int simulations = Integer.parseInt(str.get(0));
		System.out.println("Number of Weather Changes: " + simulations);
		if (simulations <= 0) {
			System.out.println("The Simulation cannot run with 0 and below.");
			System.exit(1);
		}
		System.out.println("---Crafts---");
		while (i < str.size()) {
			craft = str.get(i++);
			craftsplit = craft.split(" ", 5);
			//System.out.println(craftsplit[0]);
			//System.out.println(craft);
			Flyable flyable = AircraftFactory.newAircraft(craftsplit[0], craftsplit[1], 
			Integer.parseInt(craftsplit[2]), Integer.parseInt(craftsplit[3]), 
			Integer.parseInt(craftsplit[4]));
			if (flyable != null) {
				flyables.add(flyable);
				System.out.println(flyables);
			}
		}
		i = 0;
		while (i < flyables.size()) {
			flyables.get(i++).registerTower(subWeatherTower);
		}
		i = 0;
		while (i < simulations) {
			subWeatherTower.changeWeather();
			i++;
		}

		//for (Flyable flyable : flyables) {
		//	flyable.registerTower(subWeatherTower);
		//}
		WriteFile.writeS();
	}	
}