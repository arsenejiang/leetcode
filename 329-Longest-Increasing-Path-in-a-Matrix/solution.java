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
                result = Math.max(result, dfs(matrix, i, j, m, n, cache));
            }
        }
        
        return result;
    }
    
    private int dfs(int[][] matrix, int row, int col, int m, int n, int[][] cache) {
        if (cache[row][col] != 0) {
            return cache[row][col];
        }
        
        int max = 1;
        for(int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[row][col] ) {
                continue;
            }
            
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(len, max);
        }
        
        cache[row][col] = max;
        return max;
    }
}