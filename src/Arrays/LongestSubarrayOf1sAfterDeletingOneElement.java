package Arrays;

/*
 LeetCode 1493
 Longest Subarray of 1's After Deleting One Element
 Link : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75

 Approach:
- Sliding Window (Variable Size)
- Expand the window to the right by iterating through the array and counting the number of zeroes.
- If the count of zeroes exceeds 1, shrink the window from the left until the zero count drops back to 1 or 0.
- Calculate the valid subarray length at each step using (right - left). This naturally counts for the deletion of one element.
- Continuously track and update the maximum length found.

 Time Complexity: O(n) - Each element is processed at most twice ( once by the right pointer and once by the left).
 Space Complexity: O(1) - Only a few primitive variables are used to track indices and the counts.
 */

public class LongestSubarrayOf1sAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int zeroCount = 0;

        for(int right = 0; right < n; right++){
            if(nums[right] == 0)zeroCount++;

            while(zeroCount > 1){
                if(nums[left] == 0)zeroCount--;

                left++;
            }
            ans = Math.max(ans,right - left);
        }
        return ans;
    }
}



