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
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == arr[0]) {
                    visited[i][j] = true;
                    if (helper(board, i, j, arr, 1, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, int x, int y, char[] arr, int index, boolean[][] visited) {
        if (index == arr.length) {
            return true;
        }
        
        int[][] neighbors = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] neighbor : neighbors) {
            int i = x + neighbor[0];
            int j = y + neighbor[1];
            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                if (!visited[i][j] && board[i][j] == arr[index]) {
                    visited[i][j] = true;
                    if (helper(board, i, j, arr, index + 1, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }
}