public class Solution {
    public int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }
        
        int sign = (x > 0) ? 1 : -1;
        long num = Math.abs((long)x);
        long result = 0;
        while(num > 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }
        
        result = sign * result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        else {
            return (int)result;
        }
    }
}