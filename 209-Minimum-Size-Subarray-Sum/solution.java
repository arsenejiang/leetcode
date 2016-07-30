public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = Integer.MAX_VALUE;
        int curSum = nums[0];
        
        for(int start = 0, end = 0; end < nums.length && start < nums.length;) {
            if (curSum >= s) {
                result = Math.min(result, end - start + 1);
                if (result == 1) {
                    return result;
                }
                
                curSum -= nums[start];
                start++;
                
            }
            else {
                end++;
                if (end != nums.length) {
                    curSum += nums[end];
                }
            }
        }
        
        result result == Integer.MAX_VALUE ? 0 : result;
    }
}