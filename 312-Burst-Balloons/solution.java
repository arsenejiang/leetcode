public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] arr = new int[len + 2];
        for(int i = 1; i <= len; i++) {
            arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[len + 1] = 1;
        
        int[][] dp = new int[len  + 2][len + 2];
        return helper(dp, arr, 1, len);
    }
    
    private int helper(int[][] dp, int[] arr, int l, int r) {
        if (dp[l][r] > 0) {
            return dp[l][r];
        }
        
        for(int i = l; i <= r; i++) {
            dp[l][r] = Math.max(dp[l][r], helper(dp, arr, l, i - 1) + arr[l-1]*arr[i]*arr[r+1] + helper(dp, arr, i + 1, r));
        }
        
        return dp[l][r];
    }
}