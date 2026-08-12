package Recursion;


/*
 Subsequence with ASCII Values using Recursion

 Approach:
 - For every character, make three choices:
   1. Include the character in the current answer.
   2. Exclude the character from the current answer.
   3. Include the ASCII value of the character in the current answer.
 - Recursively process the remaining string for each of the three choices.
 - When the unprocessed string becomes empty, print the current answer.
 - Since every character has three possible choices, a string of length n
   produces 3^n possible subsequences.

 Time Complexity: O(n * 3^n)
 - There are 3^n recursive combinations.
 - Creating the resulting strings can take up to O(n) work.

 Space Complexity: O(n)
 - The recursion depth can reach n.
 - No result list is stored; each answer is printed at the base case.
*/

public class PrintAsciiValueOfACharacter {
    static void subsequencesWithAscii(String up, String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subsequencesWithAscii(up.substring(1),p + ch);
        subsequencesWithAscii(up.substring(1),p);
        subsequencesWithAscii(up.substring(1),p + (int)ch);
    }
}
