 class ArrayOperations {

    // Method to calculate sum and average of an array
    public static void sumAndAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / arr.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }

    // Method to find the maximum and minimum value in an array
    public static void findMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
    }

    // Method to print a matrix in a formatted way
    public static void printMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%4d", element); // Format with 4 spaces for alignment
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Array operations
        int[] numbers = {12, 45, 67, 23, 89, 34, 90, 21};
        sumAndAverage(numbers);
        findMaxMin(numbers);

        // 2D Array (Matrix)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printMatrix(matrix);
    }
}
