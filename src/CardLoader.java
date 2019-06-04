import java.awt.Image;
import java.io.*;
import java.util.ArrayList;

/**
  *
  * A loader for cards.
  *
  *
  * @author Felix Lehner
  */
class CardLoader {
    /**
     * Loads the cards and their attributes from a specified CSV file.
     *
     * @author Felix Lehner
     */
    public ArrayList<CountryCard> loadFrom (String path) {
        try {
            FileReader reader = new FileReader(path);
            char character = (char) reader.read();
            ArrayList<String> lines = new ArrayList<String>();
            lines.add("");
            while (Character.getNumericValue(character) != -1) {
                if (character != '\n') {
                    String temp = lines.get(lines.size() -1);
                    temp += character;
                    lines.set(lines.size() - 1, temp);
                } else {
                    lines.add("");
                }
                character = (char) reader.read();
            }
            reader.close();
            return parse(lines);
        }
        //TODO specify error messages
        catch (FileNotFoundException e) {
            System.err.println("Failed to laod the file " + path);
            return null;
        }
        catch (IOException io) {
            System.err.println("Failed to load the file " + path);
            return null;
        }
    }

    private ArrayList<CountryCard> parse (ArrayList<String> lines) {
        ArrayList<CountryCard> res = new ArrayList<CountryCard>();
        for (String in: lines) {
         //TODO optimize
         String[] attributes = in.split(",");
         
         int stars = Integer.valueOf(attributes[1]);
         
         String countryIdentifier = attributes[0];
         Country country = null; //FIXME placeholder for implementation via search for loaded name
         
         String imgDir = attributes[2];
         Image image = null; //FIXME load from imgDir
         CountryCard card = new CountryCard(stars, country);
         res.add(card);
        }
      
        return res;
    }
}
