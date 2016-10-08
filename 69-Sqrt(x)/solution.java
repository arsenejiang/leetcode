public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        
        long left = 1;
        long right = x;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long val = mid * mid;
            if (val == x) {
                return (int)mid;
            }
            else if (val < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return (int)right;
    }
}