public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            check(board, i, 0, m, n);
            check(board, i, n - 1, m, n);
        }
        
        for(int j = 0; j < n; j++) {
            check(board, 0, j, m, n);
            check(board, m - 1, j, m, n);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void check(char[][] board, int i, int j, int m, int n) {
        if(board[i][j] == 'O') {
            board[i][j] = 'B';
            if (i > 1) {
                check(board, i - 1, j, m, n);
            }
            
            if (i < m - 2) {
                check(board, i + 1, j, m, n);
            }
            
            if (j > 1) {
                check(board, i, j - 1, m, n);
            }
            
            if (j < n - 2) {
                check(board, i, j + 1, m, n);
            }
        }
    }
}