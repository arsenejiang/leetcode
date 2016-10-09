public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        else if (len == 2) {
            return Math.min(nums[0], nums[1]);
        }
        
        int left = 0;
        int right = len - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midLeft = (mid - 1) % len;
            int midRight = (mid + 1) % len;
            if (nums[mid] < nums[midLeft] && nums[mid] < nums[midRight]) {
                return nums[mid];
            }
            else if (nums[left] < nums[mid]) {
                if (nums[mid] < nums[right]) {
                    return nums[left];
                }
                else {
                    left = mid + 1;
                }
            }
            else if (nums[left] > nums[mid]) {
                right = mid - 1;
            }
            else {
                left++;
            }
        }
        
        return 0;
    }
}