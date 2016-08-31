public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        
        int res = 0;
        boolean same = false;
        for(int i = 0; i < len; i++) {
            if (nums[i] == nums[i+1]) {
                same = true;
                continue;
            }
            
            if (same) {
                res++;
                same = false;
            }
            
            if (i == 0) {
                if (nums[i] != nums[i+1]) {
                    res++;
                }
            }
            else if (i == len - 1) {
                if (nums[i - 1] != nums[i]) {
                    res++;
                }
            }
            else if ((nums[i] > nums[i-1] && nums[i] > nums[i+1]) || (nums[i] < nums[i-1] && nums[i] < nums[i+1])) {
                res++;
            }
        }
        
        if (same) {
            res++;
        }
        
        return res;
    }
}