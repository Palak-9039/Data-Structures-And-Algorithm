package Arrays;

/*

 LeetCode 135
 Candy
 Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&

 Approach:
 - Every child must receive at least one candy.
 - Create two arrays:
   1. left[]  -> stores the minimum candies required while checking from left to right.
   2. right[] -> stores the minimum candies required while checking from right to left.

 - Left Pass:
   - If the current child's rating is greater than the previous child's rating,
     assign one more candy than the previous child.
   - Otherwise, assign 1 candy.

 - Right Pass:
   - If the current child's rating is greater than the next child's rating,
     assign one more candy than the next child.
   - Otherwise, assign 1 candy.

 - For every child, take the maximum value from left[i] and right[i].
 - This ensures that both neighbor conditions are satisfied simultaneously.
 - Sum all the candies to get the minimum candies required.

 Why This Works:
 - The left pass satisfies the condition with respect to the left neighbor.
 - The right pass satisfies the condition with respect to the right neighbor.
 - Taking the maximum ensures both conditions are maintained while using the minimum valid number of candies.

 Time Complexity: O(n)
 - Two linear passes and one pass to calculate the answer.

 Space Complexity: O(n)
 - Two additional arrays are used.
*/

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int totalCandies = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            totalCandies += Math.max(left[i], right[i]);
        }

        return totalCandies;
    }
}
