public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }
        
        int[] res = new int[digits.length];
        for(int i = 0; i < digits.length; i++) {
            res[i] = digits[i];
        }
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int val = res[i] + carry;
            res[i] = val % 10;
            carry = val / 10;
            if (carry == 0) {
                return res;
            }
        }
        
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}