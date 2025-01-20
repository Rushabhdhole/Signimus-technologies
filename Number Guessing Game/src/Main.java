import java.util.Scanner;
import java.util.Random;

 class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a random number between 1 and 100.");
        System.out.println("Can you guess what it is?");


        long startTime = System.currentTimeMillis();

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number.");
            }
        } while (guess != randomNumber);


        long endTime = System.currentTimeMillis();


        long elapsedTime = endTime - startTime;

        System.out.println("It took you " + attempts + " attempts to guess the number.");
        System.out.println("You took " + (elapsedTime / 1000.0) + " seconds to finish the game.");


        System.out.print("Would you like to play again? (yes/no): ");
        String playAgain = scanner.next();

        if (playAgain.equalsIgnoreCase("yes")) {
            System.out.println("Restarting the game...");
            main(new String[]{}); // Restart the game
        } else {
            System.out.println("Thank you for playing! Goodbye.");
        }

        scanner.close();
    }
}
