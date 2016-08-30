public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxIndex = 0, max = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > max) {
                        max = dp[i];
                        maxIndex = i;
                    }
                    break;
                }
            }
        }
        
        res.add(nums[maxIndex]);
        for(int i = maxIndex - 1, index = maxIndex; i >= 0; i--) {
            if (nums[maxIndex] % nums[i] == 0) {
                res.add(nums[i]);
                index = i;
            }
        }
        
        return res;
    }
}