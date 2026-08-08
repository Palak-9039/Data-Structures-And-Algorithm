package Recursion;

import java.util.ArrayList;
import java.util.List;

 /*
  Subset of a String using Recursion

  Approach:
  - For every character, make two choices:
    1. Include the current character in the answer.
    2. Exclude the current character from the answer.
  - Recursively process the remaining unprocessed string for both choices.
  - Each recursive call returns a list containing all subsets generated
    from that smaller problem.
  - Combine the lists returned by both recursive calls using addAll().
  - When the unprocessed string becomes empty, add the current answer
    to a new list and return it.
  - The empty string is also included because it represents the empty subset.

  Time Complexity: O(2^n)
  - Each character creates two recursive branches, resulting in 2^n subsets.
  - Additional string/list operations can add overhead.

  Space Complexity: O(2^n)
  - The final result contains 2^n subsets.
  - Recursion and intermediate lists also require additional space.
 */

public class SubsetPattern {
    public static void main(String[] args) {
        System.out.println(subsetOfString("abc",""));
    }

    static List<String> subsetOfString(String up, String ans){
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        List<String> ansList = new ArrayList<>();
        ansList.addAll(subsetOfString(up.substring(1),ans + up.charAt(0)));
        ansList.addAll(subsetOfString(up.substring(1),ans));

        return ansList;
    }
}
