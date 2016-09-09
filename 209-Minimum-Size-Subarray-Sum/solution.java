public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int curSum = nums[left];
        if (curSum >= s) {
            return 1;
        }
        
        while(left < nums.length && right < nums.length) {
            if (curSum < s) {
                right++;
                if (right < nums.length) {
                    curSum += nums[right];
                }
            }
            else {
                minLen = Math.min(right - left + 1, minLen);
                if (left < right) {
                    curSum -= nums[left];
                    left++;
                }
                else {
                    return 1;
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}