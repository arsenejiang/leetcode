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
        HashMap<Character, List<int[]>> map = new HashMap();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = j;
                if(map.containsKey(board[i][j])) {
                    map.get(board[i][j]).add(pos);
                }
                else {
                    List<int[]> list = new ArrayList();
                    list.add(pos);
                    map.put(board[i][j], list);
                }
            }
        }
        
        if (map.containsKey(word.charAt(0))) {
            for(int[] pos : map.get(word.charAt(0))) {
                char c = board[pos[0]][pos[1]];
                board[pos[0]][pos[1]] = '.';
                if (exist(board, m, n, pos[0], pos[1], 1, word)) {
                    return true;
                }
                board[pos[0]][pos[1]] = c;
            }
            return false;
        }
        else {
            return false;
        }
        
    }
    
    private boolean exist(char[][] board, int m, int n, int row, int col, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        
        if (row - 1 >= 0) {
            if (board[row - 1][col] == word.charAt(index)) {
                char c = board[row - 1][col];
                board[row - 1][col] = '.';
                if (exist(board, m, n, row - 1, col, index + 1, word)) {
                    return true;
                }
                board[row - 1][col] = c;
            }
        }
        
        if (row + 1 < m) {
            if (board[row + 1][col] == word.charAt(index)) {
                char c = board[row + 1][col];
                board[row + 1][col] = '.';
                if (exist(board, m, n, row + 1, col, index + 1, word)) {
                    return true;
                }
                board[row + 1][col] = c;
            }
        }
        
        if (col - 1 >= 0) {
            if (board[row][col - 1] == word.charAt(index)) {
                char c = board[row][col - 1];
                board[row][col - 1] = '.';
                if (exist(board, m, n, row, col - 1, index + 1, word)) {
                    return true;
                }
                board[row][col - 1] = c;
            }
        }
        
        if (col + 1 >= 0) {
            if (board[row][col + 1] == word.charAt(index)) {
                char c = board[row][col + 1];
                board[row][col + 1] = '.';
                if (exist(board, m, n, row, col + 1, index + 1, word)) {
                    return true;
                }
                board[row][col + 1] = c;
            }
        }
        
        return false;
    }
}