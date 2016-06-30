public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> cur = new ArrayList();
        boolean[] used = new boolean[nums.length];
        helper(nums, used, cur, res);
        return res;
    }
    
    private void helper(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
                continue;
            }
            
            used[i] = true;
            cur.add(nums[i]);
            helper(nums, used, cur, res);
            cur.remove(cur.size() - 1);
            used[index] = false;
        }
    }
}