public class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        else if (n == 3) {
            return 2;
        }
        else if (n == 4) {
            return 4;
        }
        
        int result = 1;
        while(n > 4) {
            result = result * 3;
            n = n - 3;
        }
        
        if (n == 2) {
            return 2 * result;
        }
        else if (n == 3) {
            return 3 * result;
        }
        else {
            return 4 * result;
        }
    }
}