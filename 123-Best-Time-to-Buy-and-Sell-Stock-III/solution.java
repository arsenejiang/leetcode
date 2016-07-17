public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int len = prices.length;
        int[] arrayA = new int[len];
        int min = prices[0];
        for(int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            arrayA[i] = Math.max(arrayA[i-1], prices[i] - min);
        }
        
        int[] arrayB = new int[len];
        int max = prices[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            arrayB[i] = Math.max(arrayB[i+1], max - prices[i]);
        }
        
        int maxProfit = 0;
        for(int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit, arrayA[i] + arrayB[i]);
        }
        
        return maxProfit;
    }
}