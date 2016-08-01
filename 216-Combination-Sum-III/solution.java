public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> cur = new ArrayList();
        helper(res, cur, 1, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int start, int k, int sum) {
        if (sum < start || cur.size() == k) {
            if (sum == 0 && cur.size() == k) {
                res.add(new ArrayList(cur));
            }
            return;
        }
        
        for(int i = start; i <= sum && i <= 9; i++) {
            cur.add(i);
            helper(res, cur, i + 1, k, sum - i);
            cur.remove(cur.size() - 1);
        }
    }
}