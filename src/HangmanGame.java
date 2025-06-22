import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {
    public static void start(String secret) {
        int secretLen = secret.length();
        System.out.println("Welcome to the game, Hangman!");
        System.out.printf("I am thinking of a word that is %d letters long.\n", secretLen);

        int state = 0;

        String availableLetters = "";
        String guessedWord = "";
        String lettersGuessed = "";
        ArrayList<String> usedLetters = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            availableLetters = getAvailableLetters(lettersGuessed);
            System.out.println("-------------");
            System.out.printf("Available letters: %s\n", availableLetters);

            System.out.print("Please guess a letter: ");

            String letter = sc.next().toLowerCase();
            printUsedWords(letter, usedLetters);

            if (isLetterIncorrect(letter, guessedWord, lettersGuessed)) {
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
                guessedWord = getGuessedWord(secret, lettersGuessed);
                printGuessedWord(guessedWord);

                if (isWordGuessed(secret, lettersGuessed)) {
                    System.out.println("Congratulations, you won!");
                    break;
                }
            } else {
                System.out.print("Oops! That letter is not in my word: ");
                printGuessedWord(guessedWord);
                state++;
                HangmanDrawing.draw(state);

                System.out.println("Your state: " + state);
                if (state == 7) {
                    System.out.println("-------------");
                    System.out.printf("Sorry, you ran out of guesses. The word was %s.\n", secret);
                    break;
                }
            }
        }
    }

    private static boolean isLetterIncorrect(String letter, String guessedWord, String lettersGuessed) {
        if (!(letter.charAt(0) >= 'a' && letter.charAt(0) <= 'z')) {
            System.out.printf("Oops! '%s' is not a valid letter. Please enter an English letter: ", letter);

            printGuessedWord(guessedWord);
            return true;
        }

        if (letter.length() > 1) {
            System.out.println("Please enter one letter");
            return true;
        }

        return false;
    }

    private static void printGuessedWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            System.out.printf(" %c", word.charAt(i));
        }
        System.out.println();
    }


    private static boolean isWordGuessed(String secret, String lettersGuessed) {
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

    private static String getGuessedWord(String secret, String lettersGuessed) {
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

    private static String getAvailableLetters(String lettersGuessed) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder availableLettersBuilder = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            if (lettersGuessed.indexOf(alphabet.charAt(i)) == -1) {
                availableLettersBuilder.append(alphabet.charAt(i));
            }
        }
        return availableLettersBuilder.toString();
    }

    private static void printUsedWords(String letter, ArrayList<String> usedLetters) {
        if (letter.length() > 1 || !(letter.charAt(0) >= 'a' && letter.charAt(0) <= 'z')) {
            return;
        }
        usedLetters.add(letter);
        System.out.println("Letters you used: " + usedLetters);
    }
}