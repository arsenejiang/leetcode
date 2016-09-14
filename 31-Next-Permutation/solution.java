public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int len = nums.length;
        int candidateIndex = len - 1;
        int swapIndex = -1;
        for(int i = len - 1; i > 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && j > swapIndex) {
                    swapIndex = j;
                    candidateIndex = i;
                    break;
                }
            }
        }
        
        if (swapIndex == -1) {
            reverse(nums);
            return;
        }
        
        int temp = nums[swapIndex];
        nums[swapIndex] = nums[candidateIndex];
        nums[candidateIndex] = temp;
        
        Arrays.sort(nums, swapIndex + 1, len - 1);
    }
    
    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}