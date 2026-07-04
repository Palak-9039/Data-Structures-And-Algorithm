package Arrays;


/*
 LeetCode 1004
 Max Consecutive Ones III
 Link : https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75

 Approach:
- Sliding Window (Variable Size)
- Expand the window to the right by iterating through the array and counting the number of zeroes.
- If the count of zeroes exceeds k, shrink the window from the left until the zero count drops back to <= k.
- Calculate the valid subarray length at each step using (right - left + 1).
- Continuously track and update the maximum length found.

 Time Complexity: O(n) - Each element is processed at most twice ( once by the right pointer and once by the left).
 Space Complexity: O(1) - Only a few primitive variables are used to track indices and the counts.
 */

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int ans = 0;
        int zeroCount = 0;

        for(int right = 0; right < n; right++){
            if(nums[right] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[left]==0)zeroCount--;

                left++;
            }

            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }
}
