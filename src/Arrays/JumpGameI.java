package Arrays;


/*
 LeetCode 55
 Jump Game
 Link : https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150

 Approach:
 - Greedy
 - Initialize a variable furthest to keep track of the farthest index that can be reached.
 - Traverse the array from left to right.
 - Before processing the current index, check if it is reachable.
 - If the current index is greater than furthest, return false since it cannot be reached.
 - Otherwise, update furthest as the maximum of its current value and 'i + nums[i]'.
 - If the traversal completes successfully, return true since every required index was reachable.

 Why This Works:

 - 'furthest' always represents the farthest index that can be reached using the jumps seen so far.
 - If the current index is beyond 'furthest', there is no valid way to reach it, making it impossible to proceed further.
 - By continuously extending the farthest reachable index whenever possible, the algorithm greedily ensures the maximum reachable range at every step.
 - If no unreachable index is encountered during the traversal, the last index is guaranteed to be reachable.

 Time Complexity: O(n) - The array is traversed only once.
 Space Complexity: O(1) - Only a single variable is used to track the farthest reachable index.
*/

public class JumpGameI {
    public boolean canJump(int[] nums) {
        int furthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > furthest) return false;

            furthest = Math.max(furthest, i + nums[i]);
        }
        return true;
    }
}
