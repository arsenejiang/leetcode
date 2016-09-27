public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int curMax = nums[0], curMin = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int m1 = curMax * nums[i];
            int m2 = curMin * nums[i];
            curMax = Math.max(Math.max(m1, m2), nums[i]);
            curMin = Math.min(Math.min(m1, m2), nums[i]);
            max = Math.max(max, curMax);
        }
        
        return max;
    }
}