package main;

import game.HangmanGame;
import game.WordChoice;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String secret = WordChoice.getRandomWord();

        if (secret == null) {
            System.out.println("The program is forced to suspend its work. Bye, Pinocchios.");
            return;
        }
        System.out.println(secret);
        int secretLen = secret.length();
        System.out.println("Welcome to the game, Hangman!");
        System.out.printf("I am thinking of a word that is %d letters long.\n", secretLen);

        while (true) {
            HangmanGame.start(secret);

            if (HangmanGame.isGameFinished) {
                String answer;

                while (true) {
                    System.out.println("Do you want to play one more time? [yes/no]");
                    System.out.print("Your answer: ");
                    answer = sc.next().toLowerCase();

                    if (answer.equals("yes")) {
                        System.out.println("Let's play one more time!");
                        HangmanGame.isGameFinished = false;
                        break;
                    } else if (answer.equals("no")) {
                        System.out.println("Thanks for the game. See you next time!");
                        sc.close();
                        System.exit(0);
                    } else {
                        System.out.println("Oops! That answer isn't valid. Please type 'yes' or 'no'.");
                    }
                }
            }
        }


    }
}
