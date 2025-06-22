import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HangmanGame {
    public static void gameLoop(String secret) {
        int secretLen = secret.length();
        System.out.println("Welcome to the game, Hangman!");
        System.out.printf("I am thinking of a word that is %d letters long.\n", secretLen);

        int guessCount = 8;

        String availableLetters = "";
        String guessedWord = "";
        String lettersGuessed = "";
        ArrayList<String> usedLetters = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            HangmanDrawing.draw(guessCount);

            availableLetters = getAvailableLetters(lettersGuessed);
            System.out.println("-------------");
            System.out.printf("You have %d guesses left.\n", guessCount);
            System.out.printf("Available letters: %s\n", availableLetters);

            System.out.print("Please guess a letter: ");

            String letter = sc.next().toLowerCase();
            usedLetters.add(letter);

            System.out.println("Letters you used: " + usedLetters);

            if (!(letter.charAt(0) >= 'a' && letter.charAt(0) <= 'z')) {
                System.out.printf("Oops! '%s' is not a valid letter. Please enter an English letter: ", letter);
                guessedWord = getGuessedWord(secret, lettersGuessed);
                printGuessedWord(guessedWord);
                continue;
            }

            if (lettersGuessed.contains(letter)) {
                System.out.print("Oops! You've already guessed that letter: ");
                guessedWord = getGuessedWord(secret, lettersGuessed);
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
                    HangmanDrawing.draw(guessCount);
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
