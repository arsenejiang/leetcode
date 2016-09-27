public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int max = 0;
        for(int i = 0; i <= prices.length - 1; i++) {
            max = Math.max(max, maxProfit(prices, 0, i) + maxProfit(prices, i, prices.length - 1));
        }
        
        return max;
    }
    
    private int maxProfit(int[] prices, int start, int end) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            else {
                max = Math.max(max, prices[i] - min);
            }
        }
        
        return max;
    }
}