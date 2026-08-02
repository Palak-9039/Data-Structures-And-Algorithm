package Arrays;

/*
 Minimum Size Subarray Sum

 Approach:
 - Use the Sliding Window technique since all the elements in the array are positive.
 - Maintain two pointers, left and right, to represent the current window.
 - Expand the window by moving the right pointer and keep adding elements to the current sum.
 - Whenever the current sum becomes greater than or equal to the target, the current window becomes valid.
 - Record the length of the current window if it is smaller than the minimum answer found so far.
 - Shrink the window by removing the leftmost element from the current sum and moving the left pointer forward.
 - Continue shrinking the window until the sum becomes smaller than the target.
 - Repeat the process until the right pointer reaches the end of the array.

 Why This Works:

 - Since all the elements are positive, expanding the window always increases the sum, while shrinking the window always decreases it.
 - Once a valid window is found, removing unnecessary elements helps find the minimum possible valid window.
 - Each element is added to and removed from the window at most once, making the solution efficient.

 Time Complexity: O(n) - Each element is visited at most twice.

 Space Complexity: O(1) - Only a few variables are used.
*/

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int curSum = 0;

        for(int right = 0; right < n; right++){
            curSum += nums[right];

            while(curSum >= target){
                ans = Math.min(ans,right - left + 1);
                curSum -= nums[left];
                left++;
            }


        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
