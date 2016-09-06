public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        for(int i = 0; i < board.length; i++) {
            if(!isValid(board, i, i, 0, 8)) {
                return false;
            }
            
            if(!isValid(board, 0, 8, i, i)) {
                return false;
            }
        }
        
        for(int i = 0; i < 9; i+= 3) {
            for(int j = 0; j < 9; j+= 3) {
                if (!isValid(board, i, i + 2, j, j + 2)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
        boolean[] count = new boolean[9];
        for(int i = rowStart; i <= rowEnd; i++) {
            for(int j = colStart; j <= colEnd; j++) {
                if (board[i][j] != '.') {
                    if (count[board[i][j] - '1']) {
                        return false;
                    }
                    
                    count[board[i][j] - '1'] = true;
                }
            }
        }
        
        return true;
    }
}