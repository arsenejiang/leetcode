public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        
        if (num == 1) {
            return true;
        }
        
        int left = 2, right = num / 2;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long temp = mid * mid;
            if (temp == num) {
                return true;
            }
            else if (temp > num) {
                right--;
            }
            else {
                left++;
            }
        }
        
        return false;
    }
}