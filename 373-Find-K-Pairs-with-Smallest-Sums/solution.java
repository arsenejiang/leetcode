public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return res;
        }
        
        int m = Math.min(k, nums1.length);
        int n = Math.min(k, nums2.length);
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(comp);
        for(int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0});
        }
        
        while(k-- > 0 && !pq.isEmpty()) {
            int[] p = pq.poll();
            res.add(new int[]{nums1[p[0]], nums2[p[1]]});
            if (p[1] < n - 1) {
                pq.offer(new int[]{p[0], p[1] + 1});
            }
        }
        
        return res;
    }
}