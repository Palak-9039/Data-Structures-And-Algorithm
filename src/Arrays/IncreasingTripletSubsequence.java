package Arrays;


/*
 LeetCode 334
 Increasing Triplet Subsequence
 Link : https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75

 Approach:
- Track Potential Candidates: Maintain two variables, first and second, initialized to infinity. They represent the smallest and second-smallest elements found so far that could form the start of an increasing triplet.
- Update Rules: Loop through each number (num) in the array:
- If num is less than or equal to first, update first to num.
- Else, if num is less than or equal to second, update second to num (meaning we found a valid pair where first < second).
- Else, if num is greater than both first and second, a valid triplet sequence (i < j < k with $nums[i] < nums[j] < nums[k]) is complete. Return true immediately.
- Even if the first gets overwritten by a smaller number later in the loop, any number greater than second guarantees that a valid triplet existed.

 Time Complexity: O(n)
 Space Complexity: O(1)
 */


public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {

        if(nums.length < 3)return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;



        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
