public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        helper(nums, used, cur, res);
        
        return res;
    }
    
    private void helper(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            
            if (i > 0 && nums[i-1] == nums[i] && used[i-1] == false) {
                continue;
            }
            
            cur.add(nums[i]);
            used[i] = true;
            helper(nums, used, cur, res);
            used[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}