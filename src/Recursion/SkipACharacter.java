package Recursion;

/*
 Skip a Character from String using Recursion

 Approaches Implemented:

 1. StringBuilder Accumulator
 - Pass a StringBuilder as a parameter through recursive calls.
 - Append only the characters that should be kept.
 - Efficient since the same StringBuilder object is reused.

 Time Complexity: O(n)
 Space Complexity: O(n) recursion stack



 2. Returning the Answer
 - Each recursive call returns the answer for the remaining substring.
 - If the current character should be skipped, return the result of the smaller subproblem.
 - Otherwise, return the current character concatenated with the recursive answer.

 Time Complexity: O(n^2)
 - String concatenation creates a new String at every level.

 Space Complexity: O(n)
 - Recursion stack.



 3. Passing a String as an Accumulator
 - Pass the partially built answer as a String parameter.
 - Append the current character before making the recursive call.
 - Since Strings are immutable, a new String is created at every recursive call.

 Time Complexity: O(n^2)
 Space Complexity: O(n)
*/



public class SkipACharacter {

    public static void main(String[] args) {
        String s = "abbacda";
        System.out.printf(skip(s,"",'d'));
    }

    static StringBuilder helper(String s, char c, StringBuilder ans, int i) {
        if (i == s.length()) {
            return ans;
        }

        if (s.charAt(i) != c) {
            ans.append(s.charAt(i));
        }

        return helper(s, c, ans, i + 1);
    }


    static String helper(String s, char c, int i) {
        if (i == s.length()) {
            return "";
        }

        if (s.charAt(i) == c) {
            return helper(s, c, i + 1);
        }

        return s.charAt(i) + helper(s, c, i + 1);
    }


    //
    static String helper(String s, char c, String ans, int i) {
        if (i == s.length()) {
            return ans;
        }

        if (s.charAt(i) == c) {
            return helper(s, c, ans, i + 1);
        }

        return helper(s, c, ans + s.charAt(i), i + 1);
    }


    /*
 Skip a Character from String using Recursion (Returning the Answer)

 Approach:
 - Treat the given string as the unprocessed part of the input.
 - At each recursive call, process the first character.
 - If the current character matches the character to skip,
   ignore it and recurse on the remaining substring.
 - Otherwise, include the current character in the answer
   returned by the smaller recursive call.
 - Continue until the unprocessed string becomes empty.

 Time Complexity: O(n^2)
 - substring() and String concatenation create new strings.

 Space Complexity: O(n)
 - Recursion stack.
*/
    static String skip(String up,char c){
        if(up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if(ch == c){
            return skip(up.substring(1),c);
        }else{
            return ch + skip(up.substring(1),c);
        }
    }

}
