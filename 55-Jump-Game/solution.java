public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        
        boolean[] start = new boolean[nums.length];
        int maxLen = 0;
        for(int i = 0; i <= maxLen; i++) {
            if (start[i] == true) {
                continue;
            }
            
            int cur = i;
            while(nums[cur] > 0) {
                maxLen = Math.max(maxLen, cur + nums[cur]);
                start[cur] = true;
                if (maxLen >= nums.length - 1) {
                    return true;
                }
                cur = maxLen;
            }
            
            start[cur] = true;
        }
        
        return false;
    }
}