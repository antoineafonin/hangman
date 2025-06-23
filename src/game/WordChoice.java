package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordChoice {
    private static final String filePath = "data/words.txt";

    public static String getRandomWord() {
        ArrayList<String> allWords = new ArrayList<>();

        try {
            File wordsFile = new File(filePath);
            Scanner reader = new Scanner(wordsFile);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (line != null && !line.trim().isEmpty()) {
                    String[] words = line.trim().split("\\s+");
                    allWords.addAll(Arrays.asList(words));
                }
            }

            reader.close();


        } catch (FileNotFoundException e) {
            System.out.println("""
                    The system cannot find the specified file
                    Game cannot start\s
                    Sorry bye
                   \s""");
        }

        if (allWords.isEmpty()) {
            System.out.println("File is empty");

            System.exit(0);
        }

        int randomIndex = (int) (Math.random() * allWords.size());
        return allWords.get(randomIndex);
    }
}
