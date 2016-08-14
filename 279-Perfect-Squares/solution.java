public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i * i <= n; i++) {
            dp[i*i] = 1;
        }
        
        if (dp[n] != 0) {
            return dp[n];
        }
        
        return helper(n, dp);
    }
    
    private int helper(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }
        
        dp[n] = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++) {
            dp[n] = Math.min(dp[n], helper(n - i * i, dp) + 1);
        }
        
        return dp[n];
    }
}