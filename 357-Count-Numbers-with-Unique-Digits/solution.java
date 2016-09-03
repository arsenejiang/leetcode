public class Solution {
    /*
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
    */
    
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int i = 1; i <= n; i++) {
            if (i <= 10) {
                int sum = 1;
                for (int j = 1; j <= i; j++) {
                    if (j == 1 || j == 2) {
                        sum *= 9;
                    }
                    else {
                        sum *= 9 + 2 - j;
                    }
                }
                
                dp[i] = dp[i-1] + sum;
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        
        return dp[n];
    }
}