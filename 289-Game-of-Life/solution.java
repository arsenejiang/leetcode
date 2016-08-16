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
                int count = liveCount(original, m, n, i, j);
                if (count == 3 || (count == 4 && original[i][j] == 1)) {
                    board[i][j] = 1;
                }
                else {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int liveCount(int[][] board, int m, int n, int x, int y) {
        int liveCount = 0;
        int up = x >= 1 ? x - 1 : 0;
        int down = x <= m - 2 ? x + 1 : m - 1;
        int left = y >= 1 ? y - 1 : 0;
        int right = y <= n - 2 ? y + 1 : n - 1;
        for(int i = up; i <= down; i++) {
            for(int j = left; j <= right; j++) {
                liveCount += board[i][j];
            }
        }
        
        return liveCount;
    }
}