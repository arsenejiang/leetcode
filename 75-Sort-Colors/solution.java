public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int index0 = 0;
        int index2 = nums.length - 1;
        for(int i = index0; i <= index2;) {
            if (nums[i] == 0) {
                swap(nums, i, index0);
                index0++;
                i++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, index2);
                index2--;
            }
            else {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j || nums[i] == nums[j]) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}