public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int n = ratings.length;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        for(int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                nums[i] = Math.max(nums[i], nums[i-1] + 1);
            }
        }
        
        for(int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                nums[i] = Math.max(nums[i], nums[i+1] + 1);
            }
        }
        
        int result = 0;
        for(int num : nums) {
            result += num;
        }
        
        return result;
    }
}