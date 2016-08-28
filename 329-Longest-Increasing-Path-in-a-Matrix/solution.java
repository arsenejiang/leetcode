public class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result = Math.max(result, helper(matrix, m, n, i, j, cache));
            }
        }
        
        return result;
    }
    
    private int helper(int[][] matrix, int m, int n, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        
        int max = 1;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + helper(matrix, m, n, x, y, cache);
            max = Math.max(max, len);
        }
        
        cache[i][j] = max;
        return max;
    }
}