package simulator;

import java.util.List;

public class Validator {
	public static boolean valInput(List<String> lines) {
        if (lines.size() == 0){
            System.err.format("No Data In The Specified File%n");
            System.err.format("The File Should Have The Number Of Weather Changes On The First Line%n");
            System.err.format("Then A List Of Flyables Each on Their Own Line In The Format:(Type Name Lng Lat Height)%n");
            return false; 
        }
        if (lines.size() == 1){
            System.err.format("No Flyables Provided Add A Flyable With The Format (Type Name Lng Lat Height)");
            return false; 
        }
        if (lines.get(0).length() == 0){
            System.err.format("No Data In The Specified File%n");
            System.err.format("The File Should Have The Number Of Weather Changes On The First Line%n");
            System.err.format("Then A List Of Flyables Each on Their Own Line In The Format:(Type Name Lng Lat Height)%n");
            return false; 
        }
        for (int i = 0; i < lines.get(0).length(); i++) { 
            if (lines.get(0).charAt(i) >= '0'
                && lines.get(0).charAt(i) <= '9') { 
            } 
            else { 
                System.err.format("Number Of Weather Changes Must Be An Int And Bigger Than 0.");
                return false; 
            } 
        }
		for (int l = 1; l < lines.size(); l++){
            final String[] data = lines.get(l).split("\\s+");
            if (data.length < 5){
                System.err.format("Not Enough Flyable Data Provided At Line %d%n",l+1);
                System.err.format("Please Follow The Format (Type Name Lng Lat Height)");
                return false;
            }
            if (data[0].equals("Baloon") || data[0].equals("Helicopter") || data[0].equals("JetPlane")){
            } else {
                System.err.format("Invalid Flyable Type At Line %d",l+1);
                return false;
            }
            for (int i = 0; i < data[2].length(); i++) { 
                if (data[2].charAt(i) >= '0'
                    && data[2].charAt(i) <= '9') { 
                } 
                else { 
                    System.err.format("Longitude Must Be An Int And Positive For %s|%s At Line %d",data[0], data[1], l+1);
                    return false; 
                } 
            }
            for (int i = 0; i < data[3].length(); i++) { 
                if (data[3].charAt(i) >= '0'
                    && data[3].charAt(i) <= '9') { 
                } 
                else { 
                    System.err.format("Latitude Must Be An Int And Positive For %s|%s At Line %d",data[0], data[1], l+1);
                    return false; 
                } 
            }
            for (int i = 0; i < data[4].length(); i++) { 
                if (data[4].charAt(i) >= '0'
                    && data[4].charAt(i) <= '9') { 
                } 
                else { 
                    System.err.format("Height Must Be An Int And Between 0 - 100 For %s|%s At Line %d",data[0], data[1], l+1);
                    return false; 
                } 
            }
			if (Integer.parseInt(data[2]) < 0){
                System.err.format("Longitude Must Be An Int And Positive For %s|%s At Line %d",data[0], data[1], l+1);
                return false; 
            }
            if (Integer.parseInt(data[3]) < 0){
                System.err.format("Latitude Must Be An Int And Positive For %s|%s At Line %d",data[0], data[1], l+1);
                return false; 
            }
            if (Integer.parseInt(data[4]) < 0 || Integer.parseInt(data[4]) > 100){
                System.err.format("Height Must Be An Int And Between 0 - 100 For %s|%s At Line %d",data[0], data[1], l+1);
                return false; 
            }
        }
        return true;
    }
}