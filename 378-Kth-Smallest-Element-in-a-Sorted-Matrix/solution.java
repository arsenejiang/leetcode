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
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        int m = nums1.length, n = nums2.length;
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, nums1[0]+nums2[j]));
        for(int i = 0; i < Math.min(k, m *n); i++) {
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.x], nums2[t.y]});
            if(t.x == m - 1) continue;
            pq.offer(new Tuple (t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return res;
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