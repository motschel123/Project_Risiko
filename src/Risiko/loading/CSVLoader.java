package Risiko.loading;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Loader for CSV-files.
 * @author Felix Lehner
 */
class CSVLoader {
    /**
     * Loads a file in CSV format and separates it's lines.
     * @author Felix Lehner
     * @since 13.06.19
     * @param path file path
     * @return a list of all lines
     */
    ArrayList<String> load (String path) {
        try {
            FileReader reader = new FileReader(path);
            char character = (char) reader.read();
            ArrayList<String> lines = new ArrayList<>();
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
            return lines;
        }
        catch (IOException e) {
            System.err.println("Failed to load the file " + path);
            return new ArrayList<>();
        }
    }
}
