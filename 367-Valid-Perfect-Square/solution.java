public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        
        if (num == 1) {
            return true;
        }
        
        int left = 1, right = num;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long t = mid * mid;
            if (t == num) {
                return true;
            }
            else if (t > num) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return false;
    }
}