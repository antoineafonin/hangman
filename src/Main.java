import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String secret = getRandomWord();

        assert secret != null;
        hangman(secret);
    }

    public static void hangman(String secret) {
        int secretLen = secret.length();
        System.out.println("Welcome to the game, Hangman!");
        System.out.printf("I am thinking of a word that is %d letters long.\n", secretLen);

        int guessCount = 8;

        String availableLetters;
        String guessedWord = "";
        String lettersGuessed = "";

        Scanner sc = new Scanner(System.in);

        while (true) {
            availableLetters = getAvailableLetters(lettersGuessed);
            System.out.println("-------------");
            System.out.printf("You have %d guesses left.\n", guessCount);
            System.out.printf("Available letters: %s\n", availableLetters);

            System.out.print("Please guess a letter: ");
            String letter = sc.next().toLowerCase();

            if (!Character.isAlphabetic(letter.charAt(0))) {
                System.out.printf("Oops! '%s' is not a valid letter: ", letter);
                printGuessedWord(guessedWord);
                continue;
            }

            if (lettersGuessed.contains(letter)) {
                System.out.print("Oops! You've already guessed that letter: ");
                printGuessedWord(guessedWord);
                continue;
            }

            lettersGuessed += letter;

            guessedWord = getGuessedWord(secret, lettersGuessed);

            if (secret.contains(letter)) {
                System.out.print("Good guess: ");
                printGuessedWord(guessedWord);

                if (isWordGuessed(secret, lettersGuessed)) {
                    System.out.println("Congratulations, you won!");
                    break;
                }
            } else {
                System.out.print("Oops! That letter is not in my word: ");
                printGuessedWord(guessedWord);
                guessCount--;
                if (guessCount == 0) {
                    System.out.println("-------------");
                    System.out.printf("Sorry, you ran out of guesses. The word was %s.\n", secret);
                    break;
                }
            }
        }
    }

    public static void printGuessedWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            System.out.printf(" %c", word.charAt(i));
        }
        System.out.println();
    }

    public static String getRandomWord() {
        ArrayList<String> allWords = new ArrayList<>();

        try {
            File wordsFile = new File("src/words.txt");
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
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        if (allWords.isEmpty()) {
            System.out.println("File is empty.");
            return null;
        }

        int randomIndex = (int) (Math.random() * allWords.size());
        return allWords.get(randomIndex);
    }

    public static boolean isWordGuessed(String secret, String lettersGuessed) {
        int found = 0;

        for (int i = 0; i < secret.length(); i++) {
            for (int j = 0; j < lettersGuessed.length(); j++) {
                if (secret.charAt(i) == lettersGuessed.charAt(j)) {
                    found++;
                    break;
                }
            }
        }

        return found >= secret.length();
    }

    public static String getGuessedWord(String secret, String lettersGuessed) {
        int secretLen = secret.length();

        StringBuilder guessedWordBuilder = new StringBuilder("_".repeat(secretLen));

        for (int i = 0; i < secretLen; i++) {
            char secretChar = secret.charAt(i);

            if (lettersGuessed.indexOf(secretChar) >= 0) {
                guessedWordBuilder.setCharAt(i, secretChar);
            }
        }

        return guessedWordBuilder.toString();
    }

    public static String getAvailableLetters(String lettersGuessed) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder availableLettersBuilder = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            if (lettersGuessed.indexOf(alphabet.charAt(i)) == -1) {
                availableLettersBuilder.append(alphabet.charAt(i));
            }
        }
        return availableLettersBuilder.toString();
    }
}
