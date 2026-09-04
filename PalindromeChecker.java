import java.util.Arrays;

public class PalindromeChecker {

    // Approach 1: Iterative
    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive
    static boolean isPalindromeRecursive(String text) {

        return recursiveCheck(text, 0, text.length() - 1);
    }

    static boolean recursiveCheck(
            String text, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return recursiveCheck(
            text,
            left + 1,
            right - 1
        );
    }

    // Approach 3: Array Reversal
    static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();

        char[] reversed = text.toCharArray();

        int left = 0;
        int right = reversed.length - 1;

        while (left < right) {

            char temp = reversed[left];

            reversed[left] = reversed[right];

            reversed[right] = temp;

            left++;
            right--;
        }

        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {

        String text = "madam";

        boolean iterative =
            isPalindromeIterative(text);

        boolean recursive =
            isPalindromeRecursive(text);

        boolean arrayReversal =
            isPalindromeArrayReversal(text);

        System.out.println(
            "Iterative: " +
            (iterative ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
            "Recursive: " +
            (recursive ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
            "Array Reversal: " +
            (arrayReversal ? "Palindrome" : "Not Palindrome")
        );
    }
}