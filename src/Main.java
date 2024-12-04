public class Main {
    public static void main(String[] args) {
        String secret = "hello";
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

    public static void getAvailableLetters(String secret, String availableLetters) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < secret.length(); i++) {
            boolean letterFound = false;
            for (int j = 0; j < availableLetters.length(); j++) {
                if (secret.charAt(i) == availableLetters.charAt(j)) {
                    letterFound = true;
                    break;
                }
            }

            if (letterFound) {
                alphabet.replace(secret.charAt(i), "");
                availableLetters = alphabet;
            }
        }
    }

    public static String getRandomWord() {
        return " ";
    }

    public static void hangman(String secret) {

    }
}