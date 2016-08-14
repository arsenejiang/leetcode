public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        
        for(int i = 1; i <= n; i++) {
            int square = i * i;
            if (square < n) {
                dp[square] = 1;
            }
            else if (square == n) {
                return 1;
            }
            
            if (dp[i] != 0) {
                continue;
            }
            
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }
        
        return dp[n];
    }
}