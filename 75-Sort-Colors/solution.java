public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int index0 = 0;
        int index2 = nums.length - 1;
        for(int i = 0; i < nums.length && i <= index2; i++) {
            if (nums[i] == 0) {
                if (i > index0) {
                    swap(nums, i, index0);
                    index0++;
                    i--;
                }
            }
            else if (nums[i] == 2) {
                if (i < index2) {
                    swap(nums, i, index2);
                    index2--;
                    i--;
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