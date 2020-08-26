package simulator;

import java.io.BufferedWriter;
import java.io.File; // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteFile {
	private static WriteFile writeFile = null;
	private static File file = new File("simulation.txt");
	private static FileWriter fileWrite = null;
	private static BufferedWriter buffWrite = null;

	
	public static void fileCreate() {
		try {
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				  System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static WriteFile getFile() {
		if (writeFile == null) {
			try {
				writeFile = new WriteFile();
				fileWrite = new FileWriter(file);
				buffWrite = new BufferedWriter(fileWrite);
			} catch (IOException e) {	
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
		return writeFile;
	}

	public static void writeF(String str) {
		try {
			buffWrite.write(str);
			buffWrite.newLine();
			System.out.println("Successfully wrote to the file.");
	  	} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  	}
		}

	public static void writeS() {
		try {
			buffWrite.close();
			System.out.println("Successfully close.");
	  	} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  	}
		}

	public static void main(String[] args) {
		fileCreate();
		getFile();
		WriteFile.writeF("Hello");
		WriteFile.writeF("Hello");
		writeS();
	  }
}