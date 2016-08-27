public class Solution {
    // backtracking TLE
    // need to use dp
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        
        Arrays.sort(coins);
        for(int i = 1; i <= amount; i++) {
            for(int j = coins.length - 1; j >= 0; j--) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    dp[i] = (dp[i] == - 1) ? dp[i - coins[j]] + 1 : Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount];
    }
}