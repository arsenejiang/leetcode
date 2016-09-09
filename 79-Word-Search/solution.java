public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }    
        
        char[] arr = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }
        
        board[x][y] = '.';
        boolean result = helper(board, x - 1, y, word, index + 1) ||
                         helper(board, x + 1, y, word, index + 1) ||
                         helper(board, x, y - 1, word, index + 1) ||
                         helper(board, x, y + 1, word, index + 1);
        board[x][y] = word.charAt(index);
        return result;
    }
}