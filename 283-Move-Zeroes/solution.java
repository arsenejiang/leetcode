public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int len = nums.length;
        int nonZeroIndex = 0;
        for(int i = 0, index = 0; i < len; i++) {
            if (nums[i] != 0) {
                if (i != index) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}