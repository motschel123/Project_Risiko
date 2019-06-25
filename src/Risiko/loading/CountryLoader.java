package Risiko.loading;

import Risiko.*;

import java.util.ArrayList;

/**
 * Loads countries from csv-files.
 *
 * @author Felix Lehner
 * @since 14.06.19
 */
public class CountryLoader {
    final static String countryFileName = "countries.csv";

    /**
     * Loads the cards and their attributes
     * from a specified CSV file and then parses them.
     *
     * @param folderName name of map folder
     * @author Felix Lehner
     */
    public static ArrayList<Country> loadFrom(String folderName) {
        ArrayList<String> lines = CSVLoader.load(folderName + "/" + countryFileName);
        return parseCountries(lines);
    }

    /**
     * Parses the loaded lines to countries.
     *
     * @author Felix Lehner
     * @since 14.06.19
     */
    private static ArrayList<Country> parseCountries(ArrayList<String> countries) {
        ArrayList<Country> res = new ArrayList<>();
        for (String attributes : countries) {
            int sep = attributes.indexOf(',');

            String name = attributes.substring(0, sep);

            String[] borders = attributes.substring(sep + 1).split(",");

            res.add(new Country(name, borders));
        }

        return res;
    }
}
