public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums.length;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}