package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
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
    static List<List<Integer>> subsetIterative(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        for (int num : nums) {
            int n = outer.size();

            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    /*
    Subset Generation With Duplicates - Iterative Approach

    Approach:

    - Sort the array so duplicate elements are adjacent.
    - Start with the empty subset.
    - For each element:
      - Normally, add the element to every existing subset.
      - If the current element is a duplicate of the previous element,
        only extend the subsets created during the previous iteration.
      - Use start and end indices to identify those newly created subsets.
    - This prevents generating duplicate subsets.

    Time Complexity: O(n * 2^n)

    - In the worst case, there can be 2^n subsets.
    - Copying an existing subset can take O(n).

    Space Complexity: O(n * 2^n)

    - The result may contain up to 2^n subsets.
    - Each subset can contain up to n elements.
    */

    static List<List<Integer>> subsetIterativeWithDuplicates(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < num.length; i++) {
            start = 0;
            if (i > 0 && num[i] == num[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(num[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
