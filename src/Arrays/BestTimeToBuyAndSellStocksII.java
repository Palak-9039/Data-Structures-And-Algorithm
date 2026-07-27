package Arrays;

/*
 LeetCode 122
 Best Time to Buy and Sell Stock II
 Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150

 Approach:
 - Greedy
 - Initialize the buying price (min) as the first day's price.
 - Traverse the array from left to right.
 - If the current price is greater than the buying price, sell the stock and add the profit to the total profit.
 - After selling, update the buying price to the current price to simulate buying again on the same day.
 - If the current price is less than or equal to the buying price, update the buying price to the current price.
 - Continue this process until all days have been processed.

 Why This Works:

 - Every increasing price sequence contributes to the maximum possible profit.
 - Selling whenever the price increases captures the profit between consecutive increasing days.
 - Updating the buying price after each sale allows multiple transactions without overlapping.
 - The sum of all individual profits over increasing segments is equal to the maximum achievable profit.

 Time Complexity: O(n) - The array is traversed only once.
 Space Complexity: O(1) - Only a few variables are used to track the buying price and total profit.
*/

public class BestTimeToBuyAndSellStocksII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];

        for (int price : prices) {
            if (price > min) {
                profit = profit + (price - min);
                min = price;
            } else {
                min = price;
            }
        }
        return profit;
    }
}
