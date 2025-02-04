import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class AgeValidation {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be less than 0.");
        }
        System.out.println("Age is valid.");
    }
}

 class ExceptionHandlingDemo {

    public static double divide(int numerator, int denominator) {
        try {
            return (double) numerator / denominator;
        } catch (ArithmeticException e) {
            System.err.println("Division by zero error: " + e.getMessage());
            return Double.NaN; // Or throw the exception if you want to propagate it
        }
    }


    public static void readFile(String filePath) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Division by zero handling
        System.out.print("Enter numerator: ");
        int numerator = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int denominator = scanner.nextInt();

        double result = divide(numerator, denominator);
        if (!Double.isNaN(result)) {
            System.out.println("Result of division: " + result);
        }


        // Age validation
        try {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            AgeValidation.validateAge(age);
        } catch (InvalidAgeException e) {
            System.err.println("Age validation error: " + e.getMessage());
        }

        // File reading with throws and finally
        System.out.print("Enter file path: ");
        String filePath = scanner.next();
        try {
            readFile(filePath);
        } catch (IOException e) {
            System.err.println("File reading error: " + e.getMessage());
        }

        scanner.close();
    }
}