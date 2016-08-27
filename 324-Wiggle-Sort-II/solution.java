public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        int[] copy = Arrays.copyOf(nums, len);
        int low = (len - 1) >> 1;
        int high = len - 1;
        for(int i = 0; i < len; i++) {
            nums[i] = (i % 2 == 0) ? copy[low--] : copy[high--];
        }
    }
}