 class StringManipulation {

    // Method to reverse a string
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equalsIgnoreCase(reversed);
    }

    // Method to count occurrences of a specific character in a string
    public static int countCharacterOccurrences(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    // Advanced trim method to remove all leading and trailing whitespaces
    public static String advancedTrim(String str) {
        return str.replaceAll("^\\s+|\\s+$", ""); // Removes leading and trailing spaces
    }

    public static void main(String[] args) {
        String testString = "   racecar   ";

        // Reverse string
        System.out.println("Reversed: " + reverseString(testString));

        // Check if palindrome
        System.out.println("Is palindrome: " + isPalindrome(advancedTrim(testString)));

        // Count character occurrences
        char charToCount = 'a';
        System.out.println("Occurrences of '" + charToCount + "': " + countCharacterOccurrences(testString, charToCount));

        // Advanced trim
        System.out.println("Trimmed: '" + advancedTrim(testString) + "'");
    }
}
