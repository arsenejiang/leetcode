public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if (n <= 0) {
            return res;
        }
        
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        
        int[] counts = new int[n];
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++) {
            if (counts[i] == 1) {
                q.offer(i);
            }
        }
        
        while(n > 2) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int key = q.poll();
                n--;
                for(int neighbor : map.get(key)) {
                    counts[neighbor]--;
                    if (counts[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        
        while(!q.isEmpty()) {
            res.add(q.poll());
        }
        
        return res;
    }
}