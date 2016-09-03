public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        
        int product = 1;
        for(int i = n - 2; i >= 0; i--) {
            product *= nums[i + 1];
            result[i] *= product; 
        }
        
        return result;
    }
}