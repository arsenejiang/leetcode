public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Comparator<Point> comp = new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return matrix[a.x][a.y] - matrix[b.x][b.y];
            }  
        };
        PriorityQueue<Point> pq = new PriorityQueue<Point>(comp);
        
        m = Math.min(k, m);
        n = Math.min(k, n);
        for(int i = 0; i < n; i++) {
            pq.offer(new Point(0, i));
        }
        
        k = k - 1;
        while(k-- > 0) {
            Point p = pq.poll();
            if (p.x <= m - 2) {
                pq.offer(new Point(p.x + 1, p.y));
            }
        }
        
        Point p = pq.peek();
        return matrix[p.x][p.y]; 
        
    }
    
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}