public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        Queue<Node> q = new LinkedList();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        q.offer(new Node(i, j));
                    }
                    else {
                        board[i][j] = '#';
                    }
                }
            }
        }
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x, y = node.y;
            for(int i = Math.max(x - 1, 0); i <= Math.min(x + 1, m - 1); i++) {
                if (board[i][y] == '#') {
                    board[i][y] = 'O';
                    q.offer(new Node(i, y));
                }
            }
            
            for(int j = Math.max(y - 1, 0); j <= Math.min(y + 1, n - 1); j++) {
                if (board[x][j] == '#') {
                    board[x][j] = 'O';
                    q.offer(new Node(x, j));
                }
            }
        }
        
        for(int i = 1; i < m-1; i++) {
            for(int j = 1; j < n-1; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        boolean equals(Node t) {
            return this.x == t.x && this.y == t.y;
        }
    }
}