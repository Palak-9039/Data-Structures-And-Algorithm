package Strings;


/*
 LeetCode 151
 Reverse Words in a String
 Link : https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75

 Approach:
 - Two Pointers + String Manipulation
 - Remove leading and trailing spaces using trim().
 - Split the string into words using the regular expression "\\s+" to handle one or more consecutive spaces.
 - Initialize two pointers:
       left  -> starts from the beginning of the words array.
       right -> starts from the end of the words array.
 - Swap the words at both pointers until they meet or cross, effectively reversing the order of the words.
 - Join the reversed words with a single space using String.join() and return the final string.

 * Why This Works:
 - Splitting the string isolates each word while automatically removing extra spaces.
 - Reversing the array places the words in the required order.
 - Joining the words with a single space ensures there are no leading, trailing, or multiple spaces in the final output.

 Time Complexity: O(n) - The string is traversed a constant number of times (trim, split, reverse, and join), resulting in linear time overall.
 Space Complexity: O(n) - Extra space is used to store the array of words.

 */

public class ReverseWordsInAString {

    public static String reverseWords(String str) {
        String[] words = str.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = words.length - 1;

        while (i < j) {
            reverse(words, i, j);
            i++;
            j--;
        }
        return String.join(" ", words);
    }

    static void reverse(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
