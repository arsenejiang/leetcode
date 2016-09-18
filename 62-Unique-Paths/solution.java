public class Solution {
    /*
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
    */
    
    // match solution
    public int uniquePaths(int m, int n) {
        long res = 1;
        for(int i = 1; i <= m - 1; i++) {
            res = res * (n - 1 + i) / i;
        }
        
        return (int)res;
    }
}