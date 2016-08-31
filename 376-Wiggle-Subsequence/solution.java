public class Solution {
    /*
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        
        int res = 1;
        for(int i = 0, j = 1; i < len - 1; i = j, j++) {
            if (nums[i] < nums[j]) {
                res++;
                while(j <= len - 2 && nums[j] <= nums[j+1]) {
                    j++;
                }
            }
            else if (nums[i] > nums[j]) {
                res++;
                while(j <= len - 2 && nums[j] >= nums[j+1]) {
                    j++;
                }
            }
        }
        
        return res;
    }
    */
    
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        
        int res = 1;
        for(int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                res++;
                while(i <= len - 3 && nums[i + 1] <= nums[i + 2]) {
                    i++;
                }
            }
            else if (nums[i] > nums[i + 1]) {
                res++;
                while(i <= len - 3 && nums[i + 1] >= nums[i + 2]) {
                    i++;
                }
            }
        }
        
        return res;
    }
    
}