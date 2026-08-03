package Recursion;

/*
 Skip a Character from String using Recursion

 Approaches Implemented:

 StringBuilder Accumulator
 - Pass a StringBuilder as a parameter through recursive calls.
 - Append only the characters that should be kept.
 - Efficient since the same StringBuilder object is reused.

 Time Complexity: O(n)
 Space Complexity: O(n) recursion stack


*/

public class SkipACharacter {

    static StringBuilder helper(String s, char c, StringBuilder ans, int i) {
        if (i == s.length()) {
            return ans;
        }

        if (s.charAt(i) != c) {
            ans.append(s.charAt(i));
        }

        return helper(s, c, ans, i + 1);
    }
}
