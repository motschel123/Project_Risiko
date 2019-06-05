import java.awt.Image;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.*;

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

    /**
     * This generates a list of cards from strings.
     * Expected format for every line: [name],[number of stars],[name of image] 
     * @since 05.06.19
     * @author Felix Lehner
     */
    private ArrayList<CountryCard> parse (ArrayList<String> lines) {
        ArrayList<CountryCard> res = new ArrayList<CountryCard>();
        for (String in: lines) {
         //TODO optimize
         String[] attributes = in.split(",");
         //number of stars
         int stars = Integer.valueOf(attributes[1]);
         //name of the country
         String countryIdentifier = attributes[0];
         Country country = null; //FIXME placeholder for implementation via search for loaded name
         //name of the image
         //TODO maybe use name as path
         String imgName = attributes[2];
         BufferedImage img = null;
         try {
          img = ImageIO.read(new File("strawberry.jpg"));
         } catch (IOException e) {
          System.err.println("Failed to load image "+imgName);
         }
         
       
         CountryCard card = new CountryCard(stars, country, img);
         res.add(card);
        }
      
        return res;
    }
}
