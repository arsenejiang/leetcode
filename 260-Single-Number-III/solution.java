public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        
        int bit = 1;
        while((xor & bit) == 0) {
            bit = bit << 1;
        }
        
        for(int num : nums) {
            if ((num & bit) == 0) {
                res[0] ^= num;
            }
            else {
                res[1] ^= num;
            }
        }
        
        return res;
    }
}