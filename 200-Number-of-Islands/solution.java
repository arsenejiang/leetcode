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
                    count++;
                    dfsMarking(grid, m, n, i, j);
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '.') {
                    grid[i][j] = '1';
                }
            }
        }
        
        return count;
    }
    
    private void dfsMarking(char[][] grid, int m, int n, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != '1') {
            return;
        }
        
        grid[row][col] = '.';
        dfsMarking(grid, m, n, row + 1, col);
        dfsMarking(grid, m, n, row - 1, col);
        dfsMarking(grid, m, n, row, col + 1);
        dfsMarking(grid, m, n, row, col - 1);
    }
}