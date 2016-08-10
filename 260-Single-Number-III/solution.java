public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new int[0];
        }
        
        int xor = 0;
        for(int i : nums) {
            xor = xor ^ i;
        }
        
        int lastOne = xor & (-xor);
        
        int[] res = new int[2];
        for(int i : nums) {
            if ((i && lastOne) == 0) {
                res[0] ^= i;
            }
            else {
                res[1] ^= i;
            }
        }
        
        return res;
    }
}