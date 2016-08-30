public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        
        for(int i = maxIndex, index = maxIndex; i >= 0; i--) {
            if (nums[index] % nums[i] == 0 && dp[index] = dp[i] + 1) {
                res.add(nums[i]);
                index = i;
            }
        }
        
        return res;
    }
}