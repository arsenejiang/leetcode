public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return res;
        }
        
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1] + b[0] - a[0];
            }
            
        };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, comp);
        
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int[] arr = new int[]{nums1[i], nums2[j]};
                pq.offer(arr);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        
        for(int[] arr : pq) {
            res.add(arr);
        }
        
        return res;
    }
}