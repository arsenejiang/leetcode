public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right--;
            }
        }
        
        return nums[left];
    }
}