package Risiko.loading;

import Risiko.Card;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A loader for cards.
 *
 * @author Felix Lehner
 */
public class CardLoader {
    /**
     * Loads the cards and their attributes
     * from a specified CSV file and then parses them.
     *
     * @param path file path
     * @author Felix Lehner
     */
    public ArrayList<Card> loadFrom(String path) {
        ArrayList<String> lines = new CSVLoader().load(path);
        if (lines.isEmpty()) return new ArrayList<>();
        else return parseCards(lines);
    }

    /**
     * This generates a list of cards from strings.
     * Expected format for every line: [name],[number of stars],[name of image]
     *
     * @author Felix Lehner
     * @since 05.06.19
     */
    private ArrayList<Card> parseCards(@NotNull ArrayList<String> lines) {
        ArrayList<Card> res = new ArrayList<>();
        for (String in : lines) {
            String[] attributes = in.split(",");
            //name of the country
            String countryIdentifier = attributes[0];
            //number of stars
            int stars = Integer.valueOf(attributes[1]);

            Card card = new Card(stars, countryIdentifier);
            res.add(card);
        }

        return res;
    }
}
