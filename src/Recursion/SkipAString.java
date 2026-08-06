package Recursion;

/*
 1. Skip a Substring from String using Recursion

 Approach:
 - Maintain two strings:
   - up  -> unprocessed part of the original string.
   - ans -> processed part (answer built so far).
 - At each recursive call, check if the unprocessed string starts with the substring to be skipped.
 - If it does, skip the entire substring by moving ahead by its length.
 - Otherwise, append the first character of the unprocessed string to the answer and continue recursively.
 - When the unprocessed string becomes empty, return the final answer.

 Time Complexity: O(n^2) - substring() and String concatenation create new strings.
 Space Complexity: O(n) - Recursion stack.


 2. Skip a Substring from String using Recursion (Returning the Answer)

 Approach:
 - Treat the given string as the unprocessed part of the input.
 - At each recursive call, check whether the unprocessed string starts with the target substring.
 - If it does, skip the entire substring by recursively processing the remaining string.
 - Otherwise, keep the first character and concatenate it with the answer returned by the smaller recursive call.
 - Continue until the unprocessed string becomes empty.

 Time Complexity: O(n^2)
 - substring() creates new strings.
 - String concatenation creates a new String at every recursive call.

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


    //  2. Skip a Substring from String using Recursion (returning the answer)
    static String skip(String up, String wordToSkip){
        if (up.isEmpty()) return "";

        if (up.startsWith(wordToSkip)) {
            return skip(up.substring(wordToSkip.length()), wordToSkip);
        } else {
            return up.charAt(0) + skip(up.substring(1), wordToSkip);
        }
    }
}
