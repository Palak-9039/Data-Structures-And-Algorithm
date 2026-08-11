package Recursion;

import java.util.ArrayList;
import java.util.List;

 /*
 Subsets / Subsequences of a String

 General Approach:
 - For every character, make two choices:
   1. Include the character.
   2. Exclude the character.
 - Recursively process the remaining string for both choices.
 - When the unprocessed string becomes empty, the current answer
   represents one complete subset.
 - Since every character has two choices, a string of length n
   produces 2^n subsets, including the empty subset.

 Time Complexity: O(n * 2^n)
 - There are 2^n possible subsets.
 - Building the resulting strings can take up to O(n) work.

 Space Complexity: O(n * 2^n)
 - The result contains 2^n strings with lengths up to n.
 - Recursion uses O(n) stack space.
*/


/
public class SubsetPattern {


    // Approach 1: Return the results from each recursive call.
    // Each call creates its own list and combines the results
    // returned by the two recursive branches.
    static List<String> subsetUsingReturn(String up, String ans){
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        List<String> ansList = new ArrayList<>();
        ansList.addAll(subsetUsingReturn(up.substring(1),ans + up.charAt(0)));
        ansList.addAll(subsetUsingReturn(up.substring(1),ans));

        return ansList;
    }

    // Approach 2: Use a shared list as an accumulator.
    // The same list is passed through every recursive call,
    // so each base case directly adds its result to the list.
    // No list needs to be returned or combined at every call.
    static void subsetUsingAccumulator(String up, String ans, List<String> list){
        if(up.isEmpty()){
            list.add(ans);
            return;
        }

        subsetUsingAccumulator(up.substring(1),ans + up.charAt(0),list);
        subsetUsingAccumulator(up.substring(1),ans,list);
    }
}
