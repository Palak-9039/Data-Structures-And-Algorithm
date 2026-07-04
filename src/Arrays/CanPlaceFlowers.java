package Arrays;


/*
 LeetCode 605
 Can Place Flowers
 Link : https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75

 Approach:
-Greedy Algorithm
-Traverse the flowerbed from left to right.
-For each position, check whether:

-The current plot is empty (flowerbed[i] == 0).
-The left neighbor is empty (or i == 0).
-The right neighbor is empty (or i == flowerbed.length - 1).
-If all conditions are satisfied, plant a flower at the current position.
-Decrease n after planting.
-Return true immediately if n becomes 0.

* Why Greedy Works:

-Planting a flower as soon as a valid spot is found never reduces the maximum
-number of flowers that can be planted later.
-Therefore, making the locally optimal choice at each step leads to the correct result.

Time Complexity: O(n) - Each plot is visited once.
Space Complexity: O(1) - Only a few variables are used.

*/

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean left = (i == 0) || flowerbed[i - 1] == 0;
                boolean right = (i == len - 1) || flowerbed[i + 1] == 0;

                if (left && right) {
                    flowerbed[i] = 1;
                    n--;
                }
                if (n == 0) return true;
            }
        }
        return n <= 0;

    }
}
