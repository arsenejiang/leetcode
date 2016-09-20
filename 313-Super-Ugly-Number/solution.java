public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes == null || primes.length == 0 || n <= 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(primes);
        for(int prime : primes) {
            pq.offer(prime);
        }
        
        int cur = 0;
        HashSet<Integer> visited = new HashSet<Integer>();
        n = n - 1;
        while(n > 0) {
            cur = pq.poll();
            n--;
            if (n == 0) {
                return cur;
            }
            
            for(int i = 0; i < primes.length; i++) {
                int next = cur * primes[i];
                if (!visited.contains(next)) {
                    pq.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return cur;
    }
}