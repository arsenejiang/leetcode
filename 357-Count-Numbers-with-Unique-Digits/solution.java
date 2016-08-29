public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n && i <= 10; i++) {
            int sum = 1;
            for(int j = 1; j <= i; j++) {
                if (j == 1 || j == 2) {
                    sum *= 9;
                }
                else {
                    sum *= 9 - j + 2;
                }
            }
            
            dp[i] = dp[i-1] + sum;
        }
        
        for(int i = 11; i <= n; i++) {
            dp[i] = 0;
        }
        
        return dp[n];
    }
}