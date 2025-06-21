
public class Main {
    public static void main(String[] args) {
        String secret = WordChoice.getRandomWord();

        assert secret != null;
        HangmanGame.hangman(secret);
    }
}
