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
    public CountryCard[] loadFrom (String path) {
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

    private CountryCard[] parse (ArrayList<String> lines) {
        CountryCard[] res = new CountryCard[lines.size()];
        return null;
        //TODO load the cards with the attributes contained in each line
    }
}
