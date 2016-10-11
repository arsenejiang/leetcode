public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int n = prices.length;
        int[] sell = new int[n];
        int[] buy = new int[n];
        int[] hold = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        hold[0] = 0;
        for(int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i-1], hold[i-1] - prices[i]);
            hold[i] = Math.max(sell[i-1], hold[i-1]);
            sell[i] = Math.max(hold[i-1], buy[i-1] + prices[i]);
        }
        
        return Math.max(hold[n-1], sell[n-1]);
    }
}