public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'B';
                        q.offer(new int[]{i, j});
                    }
                }
                else if (j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'B';
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] >= 2 && board[p[0] - 1][p[1]] == 'O') {
                board[p[0] - 1][p[1]] = 'B';
                q.offer(new int[]{p[0] - 1, p[1]});
            }
            
            if (p[0] <= m - 3 && board[p[0] + 1][p[1]] == 'O') {
                board[p[0] + 1][p[1]] = 'B';
                q.offer(new int[]{p[0] + 1, p[1]});
            }
            
            if (p[1] >= 2 && board[p[0]][p[1] - 1] == 'O') {
                board[p[0]][p[1] - 1] = 'B';
                q.offer(new int[]{p[0], p[1] - 1});
            }
            
            if (p[1] <= n - 3 && board[p[0]][p[1] + 1] == 'O') {
                board[p[0]][p[1] + 1] = 'B';
                q.offer(new int[]{p[0], p[1] + 1});
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}