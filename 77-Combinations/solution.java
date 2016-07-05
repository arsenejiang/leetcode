public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0) {
            return res;
        }
        
        if (k == 1) {
            for(int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList();
                list.add(i+1);
                res.add(list);
            }
            
            return res;
        }
        
        res.addAll(combine(n-1, k-1));
        for(List<Integer> list : res) {
            list.add(n);
        }
        res.addAll(combine(n-1, k));
        return res;
    }
}