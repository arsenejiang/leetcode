public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        
        int res = 1;
        for(int i = 0; i <= len - 2; i++) {
            if (nums[i] < nums[i + 1]) {
                res++;
                while(i + 2 <= len - 1 && nums[i + 1] <= nums[i + 2]) {
                    i++;
                }
            }
            else if (nums[i] > nums[i + 1]) {
                res++;
                while(i + 2 <= len - 1 && nums[i + 1] >= nums[i + 2]) {
                    i++;
                }
            }
        }
        
        return res;
    }
}