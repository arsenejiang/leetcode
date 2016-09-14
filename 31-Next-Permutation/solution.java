public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int len = nums.length;
        int i = len - 2;
        for(i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        
        int j = len - 1;
        for (j = len - 1; j > i; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        
        swap(nums, i, j);
        
        reverse(nums, i, len - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}