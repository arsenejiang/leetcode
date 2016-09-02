public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        boolean foundOne = false;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    foundOne = true;
                }
            }
        }
        
        if (!foundOne) {
            return 0;
        }
        
        int res = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }
                else {
                    if (dp[i-1][j] > 0 && dp[i][j-1] > 0 && dp[i-1][j-1] > 0) {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
        }
        
        return res * res;
    }
}