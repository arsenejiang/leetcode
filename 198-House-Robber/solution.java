public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        int max = dp[1];
        for(int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(nums[i] + dp[i-1], dp[i]);
            max = Math.max(dp[i + 1], max);
        }
        
        return max;
    }
}