package game;

public class HangmanDrawing {
    private static final String[] hangmanStates = {
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
        |      \\O/
        |       |
        |      / \\
        |      DEAD
        |
        |
        |_________
        """
    };

    public static void draw(int state) {
        System.out.println(hangmanStates[state]);
    }
}
