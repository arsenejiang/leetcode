public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            while(nums[i] < len && nums[i] != i) {
                swap(nums, i, nums[i]);
            }
        }
        
        for(int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        return len;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}