public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int minLen = Integer.MAX_VALUE;
        int curSum = nums[0];
        for(int left = 0, right = 0; left < nums.length && right < nums.length;) {
            if (curSum >= s) {
                minLen = Math.minLen(right - left + 1, minLen);
                if (minLen == 1) {
                    return minLen;
                }
                
                curSum -= nums[left];
                left++;
            }
            else {
                right++;
                if (right < nums.length) {
                    curSum += nums[right];
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}