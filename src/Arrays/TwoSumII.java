package Arrays;


/*
 LeetCode 167
 Two Sum II - Input Array Is Sorted
 Link : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

 Approach:
 - Since the array is already sorted, use two pointers:
   - left starts from the beginning.
   - right starts from the end.
 - Calculate the sum of the two elements.
 - If the sum equals the target, return their 1-based indices.
 - If the sum is smaller than the target, move the left pointer to increase the sum.
 - If the sum is greater than the target, move the right pointer to decrease the sum.
 - Continue until the pair is found.

 Why This Works:
 - The array is sorted, so moving the left pointer always increases the sum,while moving the right pointer always decreases the sum.
 - This allows us to find the target pair in a single pass without checking every pair.

 Time Complexity: O(n) - Each pointer moves at most n times.
 Space Complexity: O(1) - Only two pointers are used.
*/



public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
            else if (numbers[left] + numbers[right] < target) left++;
            else right--;
        }
        return new int[]{};
    }
}
