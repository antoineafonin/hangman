public class HangmanDrawing {
    public static void draw(int guessCount) {
        String[] hangmanStates = {
                """
        ---------
        |       |
        |
        |
        |
        |
        |
        |
        |_________
        """,
                """
        ---------
        |       |
        |       O
        |
        |
        |
        |
        |
        |_________
        """,
                """
        ---------
        |       |
        |       O
        |       |
        |
        |
        |
        |
        |_________
        """,
                """
        ---------
        |       |
        |       O
        |      /|
        |
        |
        |
        |
        |_________
        """,
                """
        ---------
        |       |
        |       O
        |      /|\\
        |
        |
        |
        |
        |_________
        """,
                """
        ---------
        |       |
        |       O
        |      /|\\
        |      /
        |
        |
        |
        |_________
        """,
                """
        ---------
        |       |
        |       O
        |      /|\\
        |      / \\
        |
        |
        |
        |_________
        """,
                """
        ---------
        |       |
        |      \\O/
        |       |
        |      / \\
        |       
        |
        |
        |_________
        """,
                """
        ---------
        |       |
        |       O
        |      /|\\
        |      / \\
        |     DEAD
        |
        |
        |_________
        """
        };

        if (guessCount >= 0 && guessCount <= 8) {
            System.out.println(hangmanStates[8 - guessCount]);
        } else {
            System.out.println("Invalid guess count");
        }

    }
}
