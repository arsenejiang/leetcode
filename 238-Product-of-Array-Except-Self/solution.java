public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        
        int p = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            p = p * nums[i + 1];
            res[i] = res[i] * p;
        }
        
        return res;
    }
}