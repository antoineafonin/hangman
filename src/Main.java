
public class Main {
    public static void main(String[] args) {
        String secret = WordChoice.getRandomWord();

        if (secret == null) {
            System.out.println("The program is forced to suspend its work. Bye, Pinocchios.");
            return;
        }

        HangmanGame.start(secret);
    }
}
