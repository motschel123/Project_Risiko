package Risiko.loading;

import java.awt.Dimension;
import java.util.*;

import Risiko.Country;

public class CountryLocationLoader {
	
	final static String LocationFileName = "countryLocations.csv";
	
	
	 public static Map<String, Dimension> loadFrom(String folderName) {
	        ArrayList<String> lines = CSVLoader.load(folderName + "/" + LocationFileName);
	        
	        return parseLocations(lines);
	    }
	
	public static Map<String, Dimension> parseLocations(ArrayList<String> locations) {
		Map<String, Dimension> res_locations = new HashMap<String, Dimension>();
		
		for (String attributes : locations) {
			String[] split = attributes.split(",");
            
            String name = split[0];
            
            int x = Integer.parseInt(split[1]);
            int y = Integer.parseInt(split[2]);
            
            Dimension dim = new Dimension(x,y);

            res_locations.put(name, dim);
        }
		
		return res_locations;
	}
}
