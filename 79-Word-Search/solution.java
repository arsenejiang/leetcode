public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        if (word == null || word.length() == 0) {
            return true;
        }
        
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(exist(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        board[row][col] = '.';
        boolean result = exist(board, word, row - 1, col, index + 1) || 
                         exist(board, word, row + 1, col, index + 1) ||
                         exist(board, word, row, col - 1, index + 1) ||
                         exist(board, word, row, col + 1, index + 1);
        board[row][col] = word.charAt(index);
        return result;
    }
}