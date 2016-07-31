public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int result = Math.max(dp[0], dp[1]);
        for(int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], nums[i-1]);
            result = Math.max(result, dp[i]);
        }
        
        int result = dp[nums.length - 1];
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], nums[i-1]);
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}