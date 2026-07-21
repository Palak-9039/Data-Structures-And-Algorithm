package HashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/*
 LeetCode 1207
 Unique Number of Occurrences
 Link : https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75

 Approach:
 - HashMap + HashSet
 - Traverse the array and store the frequency of each number in a HashMap.
 - Traverse all the frequency values stored in the HashMap.
 - Insert each frequency into a HashSet.
 - If a frequency already exists in the HashSet, it means two different numbers have the same occurrence count, so return false.
 - If all frequencies are inserted successfully, return true.

 * Why This Works:

 - A HashMap efficiently counts the occurrences of each distinct number.
 - A HashSet only stores unique values.
 - If HashSet.add() returns false, the frequency has already been encountered, proving that the occurrence counts are not unique.
 - Therefore, checking the uniqueness of all frequencies correctly
   determines the answer.

 Time Complexity: O(n) - One pass to build the frequency map and one pass over the unique elements to verify occurrence counts.
 Space Complexity: O(n) - Extra space is used for the HashMap and HashSet.
*/

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }


        Set<Integer> uniqueCounts = new HashSet<>();
        for (int count : frequencyMap.values()) {
            if (!uniqueCounts.add(count)) {
                return false;
            }
        }

        return true;
    }
}
