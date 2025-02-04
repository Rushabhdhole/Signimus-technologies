import java.io.*;
import java.util.Random;
import java.util.Scanner;

  class FileOperations {
    public static void main(String[] args) {
        String textFile = "numbers.txt";
        String sourceBinaryFile = "source.jpg";
        String destBinaryFile = "copy.jpg";

        // Task 1: Write random numbers to a file and compute their sum
        writeRandomNumbersToFile(textFile, 10);
        int sum = readNumbersAndComputeSum(textFile);
        System.out.println("Sum of numbers: " + sum);

        // Task 2: Count lines in a file using BufferedReader
        int lineCount = countLines(textFile);
        System.out.println("Number of lines: " + lineCount);

        // Task 3: Copy a binary file
        copyBinaryFile(sourceBinaryFile, destBinaryFile);
        System.out.println("Binary file copied successfully.");
    }

    // Task 1: Write random numbers to a file
    public static void writeRandomNumbersToFile(String filename, int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int num = random.nextInt(100); // Random number between 0 and 99
                writer.write(num + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read numbers from file and compute sum
    public static int readNumbersAndComputeSum(String filename) {
        int sum = 0;
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    // Task 2: Count the number of lines in a file
    public static int countLines(String filename) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // Task 3: Copy a binary file
    public static void copyBinaryFile(String source, String destination) {
        try (FileInputStream inputStream = new FileInputStream(source);
             FileOutputStream outputStream = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
