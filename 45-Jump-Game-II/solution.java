public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int len = nums.length;
        int level = 0;
        int curMax = 0;
        int nextMax = 0;
        int i = 0;
        
        while(i <= curMax) {
            level++;
            for(;i <= curMax;i++) {
                nextMax = Math.max(nextMax, i + nums[i]);
                if (nextMax >= len - 1) {
                    return level;
                }
            }
            curMax = nextMax;
        }
        
        return 0;
    }
}