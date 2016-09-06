public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !isValid(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            if (i == x) {
                continue;
            }
            
            if (board[i][y] == board[x][y]) {
                return false;
            }
        }
        
        for(int i = 0; i < board[0].length; i++) {
            if (i == y) {
                continue;
            }
            
            if (board[x][i] == board[x][y]) {
                return false;
            }
        }
        
        int xx = x / 3 * 3;
        int yy = y / 3 * 3;
        for(int i = xx; i < xx + 3; i++) {
            for(int j = yy; j < yy + 3; j++) {
                if (i == x && j == y) {
                    continue;
                }
                
                if (board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}