public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList();
        if (n <= 0) {
            return res;
        }
        
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] neighbors = new int[n];
        for(int i = 0; i < n; i++) {
            neighbors[i] = adj.get(i).size();
            if (neighbors[i] == 1) {
                res.add(i);
            }
        }
        
        while(n > 2) {
            List<Integer> tmp = new ArrayList();
            for(Integer i : res) {
                n--;
                for(Integer j : adj.get(i)) {
                    if (--neighbors[j] == 1) {
                        tmp.add(j);
                    }
                }
            }
            res = tmp;
        }
        
        return res;
        
    }
}