public class Solution {
    /*
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            return 0;
        }
        
        int n = Math.min(k, matrix.length);
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int b[]) {
                return matrix[a[0]][a[1]] - matrix[b[0]][b[1]];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, comp);
        
        for(int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i});
        }
        
        int size = 0;
        int[] arr = new int[2];
        while(k-- > 0 && !pq.isEmpty()) {
            arr = pq.poll();
            if (arr[0] < n - 1) {
                pq.offer(new int[]{arr[0] + 1, arr[1]});
            }
        }
        
        return matrix[arr[0]][arr[1]];
    }
    */
    
     public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    }
}