public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int step = 0;
        int max = 0;
        int preEnd = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == preEnd) {
                step++;
                preEnd = max;
            }
        }
        
        return step;
    }
}