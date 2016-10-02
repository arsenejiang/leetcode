public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < coins.length && coins[i] <= amount; i++) {
            dp[coins[i]] = 1;
        }
        
        for(int i = 1; i <= amount; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                continue;
            }
            
            for(int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        
        return dp[amount];
    }
}