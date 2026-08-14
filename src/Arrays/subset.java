package Arrays;

import java.util.ArrayList;
import java.util.List;

public class subset {
/*
Subset Generation - Iterative Approach

Approach:
- Start with an outer list containing the empty subset.
- For every element in the array:
  - Store the current size of the outer list.
  - Iterate only through the subsets that existed before
    processing the current element.
  - Create a copy of each existing subset.
  - Add the current element to the copied subset.
  - Add the new subset to the outer list.
- Each element effectively doubles the number of subsets.

Time Complexity: O(n * 2^n)
- There are 2^n possible subsets.
- Creating a subset may require copying up to O(n) elements.
Space Complexity: O(n * 2^n)
- The result contains up to 2^n subsets.
- Each subset can contain up to n elements.
*/
    static List<List<Integer>> subsetIterative(int[] nums){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        for(int num : nums){
            int n = outer.size();

            for(int i = 0; i < n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

}
