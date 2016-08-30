public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        
        if (num == 1) {
            return true;
        }
        
        long candidate = num / 2;
        while(candidate * candidate > num) {
            candidate--;
        }
        
        if (candidate * candidate == num) {
            return true;
        }
        else {
            return false;
        }
    }
}