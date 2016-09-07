public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int x, int y, char val) {
        for(int i = 0; i < 9; i++) {
            if (board[x][i] == val) {
                return false;
            }
        }
        
        for(int i = 0; i < 9; i++) {
            if (board[i][y] == val) {
                return false;
            }
        }
        
        int xIndex = x / 3 * 3;
        int yIndex = y / 3 * 3;
        for(int i = xIndex; i <= xIndex + 2; i++) {
            for(int j = yIndex; j <= yIndex + 2; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        
        return true;
    }
}