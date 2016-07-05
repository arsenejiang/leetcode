public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> list = new ArrayList();
            for(int i = 1; i <= k; i++) {
                list.add(i);
            }
            List<List<Integer>> res = new ArrayList();
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