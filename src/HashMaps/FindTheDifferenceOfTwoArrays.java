package HashMaps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 LeetCode 2215
 Find the Difference of Two Arrays
 Link : https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75

 Approach:
 - HashSet
 - Traverse nums1 and insert all elements into set1.
 - Traverse nums2 and insert all elements into set2.
 - Create two new HashSets:
    onlyInSet1 initialized with set1.
    onlyInSet2 initialized with set2.
 - Remove all elements of set2 from onlyInSet1.
 - Remove all elements of set1 from onlyInSet2.
 - Convert both sets into lists and add them to the final answer.

 Why This Works:

 - HashSet automatically removes duplicate elements, so each number is stored only once.
 - removeAll() efficiently removes all common elements between the two sets.
 - After removal:
    onlyInSet1 contains elements present only in nums1.
    onlyInSet2 contains elements present only in nums2.
 - Converting the sets into lists gives the required output format.

 Time Complexity: O(n + m)
 -> O(n) to build set1.
 -> O(m) to build set2.
 -> O(n + m) for removeAll() operations.

 Space Complexity: O(n + m) -> Extra space is used for the two HashSets and the result sets.
*/

public class FindTheDifferenceOfTwoArrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num : nums1)set1.add(num);
        for(int num : nums2)set2.add(num);

        Set<Integer> onlyInSet1 = new HashSet<>(set1);
        Set<Integer> onlyInSet2 = new HashSet<>(set2);

        onlyInSet1.removeAll(set2);
        onlyInSet2.removeAll(set1);

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(onlyInSet1));
        list.add(new ArrayList<>(onlyInSet2));

        return list;
    }
}
