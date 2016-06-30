public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        List<Integer> cur = new ArrayList();
        helper(nums, 0, cur, res);
        return res;
    }
    
    private void helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }
        
        for(int i = 0; i <= cur.size(); i++) {
            cur.add(i, nums[index]);
            helper(nums, index + 1, cur, res);
            cur.remove(i);
        }
    }
}