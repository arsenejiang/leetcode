public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return nums.length;
        }
        
        int count = 1, index = 1, prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                count++;
            }
            else {
                count = 1;
                prev = nums[i];
            }
            
            if (count <= 2) {
                swap(nums, i, index);
                index++;
            }
        }
        
        return index;
    }
    
    private void swap(int[] nums, int i, int index) {
        if (i == index || nums[i] == nums[index]) {
            return;
        }
        
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}