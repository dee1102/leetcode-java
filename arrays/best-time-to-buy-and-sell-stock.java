// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int min = 0;
        int max = 0;
        int diff = 0;
        while (max < prices.length && min < prices.length) {
            if (prices[max] - prices[min] == 0 && max < prices.length - 1) {
                max++;
            }
            if (prices[max] - prices[min] < 0) {
                min = max;
            }
            if (prices[max] - prices[min] > diff) {
                diff = prices[max] - prices[min];
            }
            if (max == prices.length - 1 && min < prices.length) {
                min++;
            }
            if (max < prices.length - 1) {
                max++;
            }

        }
        return diff;
    }
}

// Need to redo with simpler logic.
// Cleaned-up Logic Summary
// Track the lowest price seen so far (min) as you move through the array.
// At each step, compute the profit if you sell today: prices[i] - min
// Keep track of the maximum profit seen so far.