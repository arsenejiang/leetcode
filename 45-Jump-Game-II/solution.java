public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < len; i++) {
            int reachIndex = Math.min(len - 1, i + nums[i]);
            int step = dp[i] + 1;
            for (int j = reachIndex; j > i; j--) {
                dp[j] = Math.min(dp[j], step);
            }
        }
        
        return dp[len - 1];
    }
}