public class Solution {
    /* TLE
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(triangle, 0, 0);
    }
    
    private int helper(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        
        return triangle.get(row).get(col) + Math.min(helper(triangle, row + 1, col), helper(triangle, row + 1, col + 1));
    }
    */
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();
        int[][] dp = new int[rows][cols];
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                if (i == 0) {
                    dp[i][j] = triangle.get(i).get(j);
                }
                else if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                }
                else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                
                if (i == rows - 1) {
                    result = Math.min(dp[i][j], result);
                }
            }
        }
        
        return result;
    }
}