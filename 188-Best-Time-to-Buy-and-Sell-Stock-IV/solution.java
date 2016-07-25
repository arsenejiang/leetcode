public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) {
            return 0;
        }
        
        int len = prices.length;
        int[][] dp = new int[k+1][len];
        for(int i = 0; i < len; i++) {
            dp[0][i] = 0;
        }
        
        for(int i = 0; i < k + 1; i++) {
            dp[i][0] = 0;
        }
        
        for(int i = 1; i < k + 1; i++) {
            for(int j = 1; j < len; j++) {
                int localMax = dp[i-1][j-1] + prices[j] - prices[j-1];
                for(int l = 0; l < j - 1; l++) {
                    localMax = Math.max(localMax, dp[i-1][l] + prices[j] - prices[l]);
                }
                dp[i][j] = Math.max(dp[i][j-1], localMax);
            }
        }
        
        return dp[k][len - 1];
    }
}