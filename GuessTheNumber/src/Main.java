import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.printf("Hello %s!%n", name);


        Random randomNumber = new Random();
        int computerNumber = randomNumber.nextInt(100);
        int guessCounter = 0;
        String playAgain = " ";

        while (true) {
            if (playAgain.equals("y")) {
                computerNumber = randomNumber.nextInt(100);
                playAgain = " ";

            } else if (playAgain.equals("n")) {
                System.out.printf("Bye %s! <3", name);
                return;
            }

            System.out.print("Guess the number (1-100): ");
            String playerInput = scanner.nextLine();
            int playerNumber;

            boolean isValid = true;

            for (int i = 0; i < playerInput.length(); i++) {
                if (playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57) {
                    isValid = false;
                    break;
                }

            }

            if (isValid) {
                playerNumber = Integer.parseInt(playerInput);
                if (playerNumber > 100 || playerNumber < 1) {
                    System.out.println("Invalid input. The number must be 1=> num <=100");
                }

                if (playerNumber == computerNumber) {
                    System.out.printf("GG %s! You guessed it!%n", name);
                    System.out.println("Do you want to play again?: y/n");
                    guessCounter = 0;
                    playAgain = scanner.nextLine();
                } else if (playerNumber > computerNumber) {
                    guessCounter++;
                    System.out.println("Too High");
                    System.out.printf("Number of tries: %d/8%n", guessCounter);
                } else {
                    guessCounter++;
                    System.out.printf("Number of tries: %d/8%n", guessCounter);
                    System.out.println("Too Low");
                }
                if (guessCounter == 8) {
                    System.out.printf("You didn't guess the number! The number was: %d%n", computerNumber);
                    System.out.println("Do you want to play again?: y/n");
                    guessCounter = 0;
                    playAgain = scanner.nextLine();
                }
            } else {
                System.out.println("Invalid input.");
            }
        }
    }
}