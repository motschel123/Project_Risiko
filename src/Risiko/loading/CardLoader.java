package Risiko.loading;

import Risiko.Card;

import java.util.ArrayList;

/**
 * A loader for cards.
 *
 * @author Felix Lehner
 */
public class CardLoader {
    final static String cardsFileName = "cards.csv";

    /**
     * Loads the cards and their attributes
     * from a specified CSV file and then parses them.
     *
     * @param folderName map folder
     * @author Felix Lehner
     */
    public static ArrayList<Card> loadFrom(String folderName) {
        ArrayList<String> lines = CSVLoader.load(folderName + "/" + cardsFileName);
        return parseCards(lines);
    }

    /**
     * This generates a list of cards from strings.
     * Expected format for every line: [name],[number of stars]
     *
     * @author Felix Lehner
     * @since 05.06.19
     */
    private static ArrayList<Card> parseCards(ArrayList<String> lines) {
        ArrayList<Card> res = new ArrayList<>();
        for (String in : lines) {
            String[] attributes = in.split(",");
            //name of the country
            System.out.println("parsing "+in);
            String countryIdentifier = attributes[0];
            //number of stars
            int stars = Integer.valueOf(attributes[1]);

            Card card = new Card(stars, countryIdentifier);
            res.add(card);
        }

        return res;
    }
}
