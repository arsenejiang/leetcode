public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int len = nums.length;
        int nonZeroIndex = 0;
        for(int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                continue;
            }
            
            for(int j = Math.max(i + 1, nonZeroIndex); j < len; j++) {
                if (nums[j] != 0) {
                    swap(nums, i, j);
                    nonZeroIndex = j + 1;
                    if (nonZeroIndex == len) {
                        return;
                    }
                    break;
                }
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}