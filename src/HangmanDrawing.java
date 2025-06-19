public class HangmanDrawing {
    public static void draw(int guessCount) {
        switch (guessCount) {
            case 8 -> System.out.println(
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
                    """
            );
            case 7 -> System.out.println(
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
                    """
            );
            case 6 -> System.out.println(
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
                    """
            );
            case 5 -> System.out.println(
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
                    """
            );
            case 4 -> System.out.println(
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
                    """
            );
            case 3 -> System.out.println(
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
                    """
            );
            case 2 -> System.out.println(
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
                    """
            );
            case 1 -> System.out.println(
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
                    """
            );
            case 0 -> System.out.println(
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
            );
            default -> System.out.println("Invalid guess count");
        }
    }
}
