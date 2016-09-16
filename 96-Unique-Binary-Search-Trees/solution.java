public class Solution {
    /*
    // recursive
    public int numTrees(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        return helper(n, cache);
    }
    
    private int helper(int n, int[] cache) {
        if (cache[n] != 0) {
            return cache[n];
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++) {
            count += helper(i - 1, cache) * helper(n - i, cache);
        }
        
        cache[n] = count;
        return count;
    }
    */
    
    // iterative
    public int numTrees(int n) {
        int[] dp = new dp[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[n];
    }
}