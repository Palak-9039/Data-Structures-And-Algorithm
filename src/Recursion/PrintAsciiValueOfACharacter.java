package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 Subsequence with ASCII Values using Recursion

 Approach 1:
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


Approach 2:
 - For every character, make three recursive choices:
     1. Include the character in the current subsequence.
     2. Exclude the character.
     3. Include the ASCII value of the character.
 - Recursively process the remaining string for all three choices.
 - A single shared list is passed through all recursive calls.
 - When the unprocessed string becomes empty, add the current subsequence to the list.

Time Complexity: O(n * 3^n)
 - Each character creates 3 recursive branches, resulting in 3^n possible subsequences.
 - Constructing the resulting strings can take up to O(n) work.

Space Complexity: O(n * 3^n)
 - The result list stores 3^n subsequences, each potentially requiring O(n) space.
 - The recursion stack itself requires O(n) space.
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


    static void subsequencesWithAscii(String up, String p, List<String> list){
        if(up.isEmpty()){
            list.add(p);
            return;
        }
        char ch = up.charAt(0);
        subsequencesWithAscii(up.substring(1),p + ch,list);
        subsequencesWithAscii(up.substring(1),p,list);
        subsequencesWithAscii(up.substring(1),p + (int)ch,list);
    }
}
