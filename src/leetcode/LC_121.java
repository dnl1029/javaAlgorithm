package leetcode;

import java.io.IOException;
import java.util.HashSet;

public class LC_121 {

    /**
     * 121. Best Time to Buy and Sell Stock
     * Easy
     * 28.3K
     * 948
     * Companies
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock
     * and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * Example 2:
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     *
     *
     * Constraints:
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */

    public int maxProfit(int[] prices) {

        int result = 0;

        HashSet<Integer> resultSet = new HashSet<>();

        int minPrice = prices[0];
        for(int i=1;i<prices.length;i++) {
            if(prices[i]<minPrice) {
                minPrice = prices[i];
            }
            else if(prices[i]>minPrice) {
                resultSet.add(prices[i]-minPrice);
            }
        }

        if(!resultSet.isEmpty()) {
            result = resultSet.stream().mapToInt(i -> i.intValue()).max().getAsInt();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        LC_121 main = new LC_121();
        int[] prices = {7,1,5,3,6,4};

        System.out.println(main.maxProfit(prices));
    }
}