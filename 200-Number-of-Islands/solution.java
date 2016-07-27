public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<Node> q = new LinkedList();
                    q.offer(new Node(i, j));
                    while(!q.isEmpty()) {
                        Node p = q.poll();
                        grid[p.x][p.y] = '.';
                        if (p.x < m - 1) {
                            if (grid[p.x+1][p.y] == '1') {
                                q.offer(new Node(p.x + 1, p.y));
                            }
                        }
                        
                        if (p.x > 0) {
                            if (grid[p.x-1][p.y] == '1') {
                                q.offer(new Node(p.x - 1, p.y));
                            }
                        }
                        
                        if (p.y < n - 1) {
                            if (grid[p.x][p.y + 1] == '1') {
                                q.offer(new Node(p.x, p.y + 1));
                            }
                        }
                        
                        if (p.y > 0) {
                            if (grid[p.x][p.y - 1] == '1') {
                                q.offer(new Node(p.x, p.y - 1));
                            }
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '.') {
                    grid[i][j] = '1';
                }
            }
        }
        
        return count;
    }
    
    public class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}