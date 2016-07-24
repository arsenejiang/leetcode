public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        long[] dp = new long[len];
        dp[0] = nums[0];
        
        for(int i = 1; i < len; i++) {
            long localMax = nums[i];
            long product = nums[i];
            for(int j = i - 1; j >= 0; j--) {
                product = product * nums[j];
                localMax = Math.max(localMax, product);
            }
            
            dp[i] = Math.max(dp[i-1], localMax);
        }
        
        return (int)dp[len - 1];
    }
}