package Arrays;

/*
 LeetCode 42
 Trapping Rain Water
 Link : https://leetcode.com/problems/trapping-rain-water/

 Approach:
 - Two Pointers + Greedy
 - Initialize two pointers, one at the beginning (left) and one at the end (right) of the array.
 - Maintain two variables, leftMax and rightMax, to store the highest bar encountered so far from the left and right respectively.
 - Compare the heights at both pointers.
 - If height[left] <= height[right], process the left side:
   - Update leftMax if the current bar is taller.
   - Otherwise, the water trapped at the current position is (leftMax - height[left]).
   - Move the left pointer forward.
 - Otherwise, process the right side:
   - Update rightMax if the current bar is taller.
   - Otherwise, the water trapped at the current position is (rightMax - height[right]).
   - Move the right pointer backward.
 - Continue until both pointers meet and return the total trapped water.

 * Why This Works:

 - Water trapped at any index depends on the shorter boundary between the tallest bar on its left and the tallest bar on its right.
 - When height[left] <= height[right], there is guaranteed to be a boundary on the right that is at least as tall as the current left bar.
 - Therefore, the amount of water on the left side is completely determined by leftMax, making it safe to process the left pointer.
 - Similarly, when height[right] < height[left], the right side is the limiting boundary, so the trapped water depends only on rightMax.
 - Each pointer is processed exactly once, allowing the solution to compute the trapped water in a single traversal without using extra arrays.

 Time Complexity: O(n) - Each pointer moves at most once across the array.
 Space Complexity: O(1) - Only a few variables are used.
*/

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];
        int ans = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans = ans + leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans = ans + rightMax - height[right];
                right--;
            }
        }
        return ans;

    }
}
