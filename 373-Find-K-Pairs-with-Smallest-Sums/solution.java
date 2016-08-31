public class Solution {
    // my initial solution
    // complexity: O(k^2logk)
    // 110ms
    /*
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
    */
    
    // https://discuss.leetcode.com/topic/50529/java-9ms-heap-queue-solution-k-log-k
    // 9ms solution
    // complexity: O(klogk)
    // Frist, we take the first k elements of nums1 and paired with nums2[0] as the starting pairs 
    // so that we have (0,0), (1,0), (2),.....(k-1,0) in the heap.
    // Each time after we pick the pair with min sum, we put the new pair with the second index +1. ie, pick (0,0), we put back (0,1).
    // Therefore, the heap alway maintains at most min(k, len(nums1)) elements.
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return res;
        }
        
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return nums1[a[0]] - nums1[b[0]] + nums2[a[1]] - nums2[b[1]];
            }
            
        };
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, comp);
        for(int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0});
        }
        
        while(res.size() < k && !pq.isEmpty()) {
            int[] arr = pq.poll();
            res.add(new int[]{nums1[arr[0]], nums2[arr[1]]});
            if (arr[1] + 1 < n) {
                pq.offer(new int[]{arr[0], arr[1] + 1});
            }
        }
        
        return res;
    }
    
}