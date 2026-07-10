package Strings;


/*
 LeetCode 345
 Reverse Vowels of a String
 Link : https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75

 Approach:
 - Two Pointers
 - Convert the string into a character array for easy in-place modification.
 - Initialize two pointers:
    left  -> starts from the beginning.
    right -> starts from the end.
 - Move the left pointer forward until it points to a vowel.
 - Move the right pointer backward until it points to a vowel.
 - Swap the vowels at both pointers.
 - Continue the process until the pointers meet or cross.
 - Convert the modified character array back into a string and return it.

** Why Two Pointers Work:

 - Only vowels need to be reversed while consonants remain in their
   original positions.
 - Scanning from both ends allows each vowel to be swapped directly
   with its corresponding vowel from the opposite side.
 - Since each character is visited at most once, this gives the
   optimal linear-time solution.

 Time Complexity: O(n) - Each character is processed at most once.
 Space Complexity: O(n) - Character array is used for in-place modifications.

*/


public class ReverseVowelsofAString {

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        String vowels = "aeiouAEIOU";

        while (i < j) {
            while (i < j && vowels.indexOf(arr[i]) == -1) {
                i++;
            }
            while (i < j && vowels.indexOf(arr[j]) == -1) {
                j--;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        return new String(arr);
    }


    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
