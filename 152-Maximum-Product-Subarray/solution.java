public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        int curMax, curMin;
        
        for(int i = 0; i < nums.length; i++) {
            curMax = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            curMin = Math.min(Math.min(max*nums[i], min*nums[i]), nums[i];
            res = Math.max(curMax, res);
            max = curMax;
            min = curMin;
        }
        
        return res;
    }
}