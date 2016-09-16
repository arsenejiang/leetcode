public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(n, 1, k, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int n, int start, int k, List<Integer> cur, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        if (n - start + 1 < k) {
            return;
        }
        
        for(int i = start; i <= n + 1 - k; i++) {
            cur.add(i);
            helper(n, i + 1, k - 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}