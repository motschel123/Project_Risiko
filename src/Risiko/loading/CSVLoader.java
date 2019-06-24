package Risiko.loading;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Loader for CSV-files.
 *
 * @author Felix Lehner
 */
class CSVLoader {
    /**
     * Loads a file in CSV format and separates it's lines.
     *
     * @param path file path inside {@code Assets} folder
     * @return a list of all lines
     * @author Felix Lehner
     * @since 13.06.19
     */
    public static ArrayList<String> load(String path) {
        try {
            ArrayList<String> lines = new ArrayList<>();

            InputStream input = CSVLoader.class.getClassLoader().getResourceAsStream("Assets/"+path);

            Scanner scan = new Scanner(input);
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }

            return lines;
        } catch (Exception e) {
            System.err.println("Failed to load the file " + path);
            System.err.println(e);
            return new ArrayList<>();
        }
    }
}
