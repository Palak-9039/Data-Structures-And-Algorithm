package Arrays;

/*
 LeetCode 169
 Majority Element
 Link : https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150

 Approach:
 - Moore's Voting Algorithm
 - Initialize a candidate and a frequency counter.
 - Traverse the array once.
 - If the frequency becomes 0, choose the current element as the new candidate.
 - If the current element is equal to the candidate, increment the frequency.
 - Otherwise, decrement the frequency.
 - After the traversal, the candidate represents the majority element.

 Why This Works:

 - Every occurrence of a non-majority element cancels out one occurrence of the current candidate.
 - Since the majority element appears more than ⌊n/2⌋ times, it cannot be completely canceled by all other elements combined.
 - Even if the candidate changes during the traversal, the true majority element will always remain as the final candidate.
 - The problem guarantees that a majority element always exists, so no additional verification is required.

 Time Complexity: O(n) - The array is traversed only once.
 Space Complexity: O(1) - Only two variables (candidate and frequency) are used.
*/

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int freq = 0;
        int ans = nums[0];

        for (int num : nums) {
            if (freq == 0) {
                ans = num;
            }
            if (num == ans) {
                freq++;
            } else {
                freq--;
            }
        }
        return ans;
    }
}
