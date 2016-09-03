public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 0;
        for(int i = 0; i <= n; i++) {
            if (i == 0) {
                res += 1;
            }
            else if (i == 1) {
                res += 9;
            }
            else if (i <= 10) {
                int cur = 9;
                int j = i - 1;
                while(j > 0) {
                    cur = cur * (10 - j);
                    j--;
                }
                res += cur;
            }
            else {
                break;
            }
        }
        
        return res;
    }
}