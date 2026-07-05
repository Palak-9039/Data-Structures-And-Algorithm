package Arrays;


 /*
 LeetCode 724
 Find Pivot Index / Find the Middle Index in Array
 Link : https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75

 Approach:
 - Prefix sum / Running total
 - Calculate the total sum of the array and store it in rightSum.
 - Iterate through the array, dynamically maintaining leftSum by adding the elements passed so far.
 - Deduct the current element from the rightSum to represent sum of all elements strictly on the right of the current index.
 - Compare leftSum and rightSum at each index, if they are equal that's the answer, so return the current index;

 Time Complexity: O(n) - Two independent linear passes.
 Space Complexity: O(1) - Constant space utilized.

 */

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int n = nums.length;

        for (int num : nums) {
            rightSum += num;
        }

        for(int i = 0; i < n; i++){
            leftSum = (i != 0) ? leftSum + nums[i - 1] : leftSum;
            rightSum = rightSum - nums[i];

            if(leftSum == rightSum)return i;

        }
        return -1;
    }
}
