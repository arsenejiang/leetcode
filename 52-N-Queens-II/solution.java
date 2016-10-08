public class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int[] res = new int[1];
        int[] nums = new int[n];
        helper(nums, 0, res);
        return res[0];
    }
    
    private void helper(int[] nums, int index, int[] res) {
        if (index == nums.length) {
            res[0]++;
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (isValid(nums, index, i)) {
                nums[index] = i;
                helper(nums, index, res);
            }
        }
    }
    
    private boolean isValid(int[] nums, int index, int val) {
        for(int i = 0; i < index; i++) {
            if (nums[i] == val || Math.abs(val - nums[i]) == index - i) {
                return false;
            }
        }
        
        return true;
    }
}