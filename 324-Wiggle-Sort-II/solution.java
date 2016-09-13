public class Solution {
    public void wiggleSort(int[] nums) {
        // sort approach
        if (nums == null || nums.length == 0) {
            return;
        }
        
        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, nums.length);
        int len = nums.length;
        int left = (len - 1) >> 1;
        int right = len - 1;
        for(int i = 0; i < nums.length; i++) {
            nums[i] = ((i & 1) == 0) ? copy[left--] : copy[right--];
        }
        
    }
}