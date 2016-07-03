public class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int i = 0;
        while(i < size) {
            if (digits[i] != 9) {
                break;
            }
            i++;
        }
        
        if (i == size) {
            int[] result = new int[size+1];
            result[0] = 1;
            return result;
        }
        
        int[] result = new int[size];
        int carry = 1;
        for(int i = size - 1; i >= 0; i++) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            result[i] = sum % 10;
        }
        
        return result;
    }
}