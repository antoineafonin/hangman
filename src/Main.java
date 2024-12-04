import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String secret = getRandomWord();
        System.out.printf("The random word is %s\n", secret);
        String letterGuessed = "lpapahepo";
        StringBuilder guessedLetters = new StringBuilder(letterGuessed);

        System.out.println(isLetterGuessed(secret, letterGuessed));
        getGuessedWord(secret, letterGuessed, guessedLetters);

        System.out.println(guessedLetters);
    }

    public static boolean isLetterGuessed(String secret, String lettersGuessed) {
        for (int i = 0; i < secret.length(); i++) {
            for (int j = 0; j < lettersGuessed.length(); j++) {
                if (secret.charAt(i) == lettersGuessed.charAt(j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void getGuessedWord(String secret, String lettersGuessed, StringBuilder guessedLetters) {
        guessedLetters.setLength(0);

        guessedLetters.append("_".repeat(secret.length()));

        for (int i = 0; i < secret.length(); i++) {
            char currentChar = secret.charAt(i);

            if (lettersGuessed.indexOf(currentChar) != -1) {
                guessedLetters.setCharAt(i, currentChar);
            }
        }
    }

    public static String getAvailableLetters(String secret) {
        StringBuilder alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");

        for (int i = 0; i < secret.length(); i++) {
            boolean letterFound = false;
            for (int j = 0; j < alphabet.length(); j++) {
                if (secret.charAt(i) == alphabet.charAt(j)) {
                    letterFound = true;
                    break;
                }
            }

            if (letterFound) {
                char letterToRemove = secret.charAt(i);
                int indexToRemove = alphabet.indexOf(String.valueOf(letterToRemove));

                if (indexToRemove != -1) {
                    alphabet.deleteCharAt(indexToRemove);
                }
            }
        }

        return alphabet.toString();
    }

    public static String getRandomWord() {
        Random rand = new Random();
        ArrayList<String> wordsList = new ArrayList<>();
        try {
            File words = new File("../hangman/src/words.txt");
            Scanner reader = new Scanner(words);
            while (reader.hasNextLine()) {
                wordsList.add(reader.nextLine().trim());
            }

            reader.close();

            if (!wordsList.isEmpty()) {
                int randomIndex = rand.nextInt(100);
                return wordsList.get(randomIndex);
            } else {
                System.out.println("The file is empty");
                return "";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return "";
        }
    }

    public static void hangman(String secret) {

    }
}