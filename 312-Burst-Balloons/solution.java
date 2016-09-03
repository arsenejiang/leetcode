public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] arr = new int[nums.length + 2];
        int n = arr.length;
        arr[0] = arr[n - 1] = 1;
        for(int i = 1; i < n - 1; i++) {
            arr[i] = nums[i-1];
        }
        
        int[][] dp = new int[n][n];
        return helper(arr, 0, n - 1, dp);
    }
    
    private int helper(int[] arr, int left, int right, int[][] dp) {
        if (dp[left][right] > 0) {
            return dp[left][right];
        }
        
        int res = 0;
        for(int i = left + 1; i <= right - 1; i++) {
            res = Math.max(res, arr[left]*arr[right]*arr[i] + helper(arr, left, i, dp) + helper(arr, i, right, dp));
        }
        
        dp[left][right] = res;
        return res;
    }
}