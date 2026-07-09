package Arrays;


/*
 LeetCode 643
 Maximum Average Subarray I
 Link : https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75

 Approach:
- Sliding Window (Fixed window size)
- Calculate the first k elements in the array.This acts as our initial sum window.
- Iterate through the rest of the array from index k and update the window sum by adding the incoming element nums[i] ans subtracting the outgoing element nums[i-k].
- Compare and update the maximum window sum 'max' at each iteration to ensure we are holding the highest sum found.
- Compute the final average by dividing the max by k at the end.

 Time Complexity: O(n) - We traverse the array exactly once. The initial window takes O(K) steps, and the rest of the array takes O(n - k) steps, resulting in linear time complexity.
 Space Complexity: O(1) - Only a few primitive variables (max,sum) are used, which uses a constant amount of extra memory.
 */


public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        double max = 0;
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;

        for (int i = k; i < n; i++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max / k;
    }
}
