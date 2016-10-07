public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<Integer>();
        helper(candidates, 0, target, cur, res);
        return res;
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                cur.add(candidates[i]);
                helper(candidates, i, target - candidates[i], cur, res);
                cur.remove(cur.size() - 1);
            }
            else {
                break;
            }
        }
    }
}