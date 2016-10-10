public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        int[][] original = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                original[i][j] = board[i][j];
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = getLiveCounts(original, m, n, i, j);
                if (count <= 2 || count > 4) {
                    board[i][j] = 0;
                }
                else if (count == 3) {
                    board[i][j] = 1;
                }
                else if (count == 4) {
                    board[i][j] = original[i][j];
                }
            }
        }
    }
    
    private int getLiveCounts(int[][] board, int m, int n, int x, int y) {
        int up = Math.max(x - 1, 0);
        int down = Math.min(x + 1, m - 1);
        int left = Math.max(y - 1, 0);
        int right = Math.min(y + 1, n - 1);
        int count = 0;
        for(int i = up; i <= down; i++) {
            for(int j = left; j <= right; j++) {
                count += board[i][j];
            }
        }
        
        return count;
    }
}