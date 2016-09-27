public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, m, n, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }
        
        grid[i][j] = 'I';
        dfs(grid, m, n, i - 1, j);
        dfs(grid, m, n, i + 1, j);
        dfs(grid, m, n, i, j - 1);
        dfs(grid, m, n, i, j + 1);
    }
}