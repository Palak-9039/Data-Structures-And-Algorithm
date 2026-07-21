package Arrays;

/*
 LeetCode 121
 Best Time to Buy and Sell Stock
 Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150

 Approach:
 - Greedy + One Pass
 - Maintain a variable 'minPrice' to store the minimum stock price encountered so far.
 - Traverse the array once.
 - If the current price is smaller than minPrice, update minPrice.
 - Otherwise, calculate the profit by selling at the current price after buying at minPrice.
 - Update maxProfit if the current profit is greater than the previous maximum.
 - Return the maximum profit obtained after the traversal.

 Why This Works:

 - The best day to buy before any given day is simply the day with the minimum price seen so far.
 - By keeping track of the lowest buying price, we can calculate the maximum possible profit for every selling day.
 - Updating the maximum profit at each step guarantees that the best transaction is found.


 Time Complexity: O(n) - The array is traversed only once.
 Space Complexity: O(1) - Only two variables (minPrice and maxProfit) are used.
*/

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit,prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}
