public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < k || k == 0) {
            return new ArrayList<List<Integer>>();
        }
        
        if (k == n) {
            List<Integer> list = new ArrayList();
            for(int i = 1; i <= n; i++) {
                list.add(i);
            }
            List<List<Integer>> res = new ArrayLit();
            res.add(list);
            return res;
        }
        
        List<List<Integer>> result = combine(n - 1, k - 1);
        for(List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n-1, k));
        return result;
    }
}