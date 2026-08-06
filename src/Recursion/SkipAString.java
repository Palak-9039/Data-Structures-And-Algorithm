package Recursion;

/*
 1. Skip a Substring from String using Recursion

 Approach:
 - Maintain two strings:
   - up  -> unprocessed part of the original string.
   - ans -> processed part (answer built so far).
 - At each recursive call, check if the unprocessed string starts
   with the substring to be skipped.
 - If it does, skip the entire substring by moving ahead by its length.
 - Otherwise, append the first character of the unprocessed string
   to the answer and continue recursively.
 - When the unprocessed string becomes empty, return the final answer.

 Why This Works:
 - Each recursive call processes a smaller portion of the string.
 - Whenever the target substring is found at the beginning of the
   unprocessed string, it is completely ignored.
 - Otherwise, the current character is preserved in the answer.

 Time Complexity: O(n^2)
 - substring() and String concatenation create new strings.

 Space Complexity: O(n)
 - Recursion stack.
*/

public class SkipAString {

    //  1. Skip a Substring from String using Recursion
    static String skip(String up, String wordToSkip, String ans) {
        if (up.isEmpty()) return ans;

        if (up.startsWith(wordToSkip)) {
            return skip(up.substring(wordToSkip.length()), wordToSkip, ans);
        } else {
            return skip(up.substring(1), wordToSkip, ans + up.charAt(0));
        }
    }
}
