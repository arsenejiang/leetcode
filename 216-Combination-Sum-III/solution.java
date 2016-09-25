public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(9, k, n, cur, res);
        return res;
    }
    
    private void helper(int num, int k, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target < 0 || (target == 0 && k != 0)) {
            return;
        }
        
        if (k == 0 && target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        
        for(int i = num; i >= 1; i--) {
            cur.add(i);
            helper(i - 1, k - 1, target - i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}