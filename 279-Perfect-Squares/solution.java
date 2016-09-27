public class Solution {
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            int square = i * i;
            if (square < n) {
                nums[square] = 1;
            }
            else if (square == n) {
                return 1;
            }
            
            if (nums[i] != 0) {
                continue;
            }
            
            nums[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                nums[i] = Math.min(nums[i], 1 + nums[i - j * j]);
            }
        }
        
        return nums[n];
    }
}