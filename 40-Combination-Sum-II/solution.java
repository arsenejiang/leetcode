public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<Integer>();
        helper(candidates, 0, path, target, res);
        return res;
    }
    
    private void helper(int[] candidates, int start, List<Integer> path, int target, List<List<Integer>> res) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            if (target < candidates[start]) {
                break;
            }
            
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            path.add(candidates[i]);
            helper(candidates, i + 1, path, target - candidates[i], res);
            path.remove(path.size() - 1);
        }
    }
}