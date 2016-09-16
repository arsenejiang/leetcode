public class Solution {
    public int getSum(int a, int b) {
        int carry = a & b;
        a = a ^ b;
        while(carry != 0) {
            b = carry << 1;
            carry = a & b;
            a = a ^ b;
        }
        
        return a;
    }
}