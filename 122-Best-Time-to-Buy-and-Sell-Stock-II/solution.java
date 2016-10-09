public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int maxProfit = 0;
        int prev = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] > prev) {
                maxProfit += prices[i] - prev;
                prev = prices[i];
            }
            else {
                prev = prices[i];
            }
        }
        
        return maxProfit;
    }
}