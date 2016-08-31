public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        
        int res = 1;
        boolean same = false;
        for(int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i+1]) {
                res++;
                while(i <= n - 2 && nums[i] <= nums[i+1]) {
                    i++;
                }
            }
            else if (nums[i] > nums[i+1]) {
                res++;
                while(i <= n - 2 && nums[i] >= nums[i+1]) {
                    i++;
                }
            }
        }
        
        return res;
    }
}