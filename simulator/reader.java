package simulator;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class reader {
	private static List<String> readFile(String filename)
	{
	  List<String> records = new ArrayList<String>();
	  try
	  {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	    	records.add(line);
	    }
	    reader.close();
	    return records;
	  }
	  catch (Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
	
	public static void main(String[] args) {
		String filename = "scenario.txt";
		List<String> str = readFile(filename);
		int i = 1;
		String craft;
		String[] craftsplit;
		System.out.println("---List---");
		System.out.println(str);
		System.out.println("---Weather---");
		System.out.println("Number of Weather Changes: " + str.get(0));
		System.out.println("---Crafts---");
		while (i < str.size()) {
			craft = str.get(i++);
			craftsplit = craft.split(" ", 5);
			System.out.println(craftsplit[0]);
			System.out.println(craft);
		}
	}	
}