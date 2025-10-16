

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1; // Random number 1-100
        int maxAttempts = 10; // Limit attempts
        int attempts = 0;
        boolean guessed = false;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("Guess the number between 1 and 100!");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Attempts left: " + (maxAttempts - attempts));
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Attempts left: " + (maxAttempts - attempts));
            } else {
                System.out.printf("🎉 Congratulations! You guessed the number in %d attempts.%n", attempts);
                guessed = true;
                break;
            }
        }

        if (!guessed) {
            System.out.println("Sorry, you've used all attempts. The number was: " + numberToGuess);
        }

        sc.close();
    }
}
