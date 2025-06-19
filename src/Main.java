public class Main {
    public static void main(String[] args) {

    }

    public static void hangman() {}

    public static String getRandomWord() {

    }

    public static boolean isWordGuessed(String secret, String lettersGuessed) {
        int found = 0;

        for (int i = 0; i < secret.length(); i++) {
            for (int j = 0 ; j < lettersGuessed.length(); i++) {
                if (secret.charAt(i) == lettersGuessed.charAt(j)) {
                    found++;
                    break;
                }
            }
        }

        return found >= secret.length()
    }

    public static void getAvailableLetters(String lettersGuessed, String availableLetters) {}
}