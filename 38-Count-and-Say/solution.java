public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        
        StringBuilder[] dp = new StringBuilder[n + 1];
        dp[1] = new StringBuilder("1");
        for(int i = 2; i <= n; i++) {
            char prev = dp[i - 1].charAt(0);
            int count = 1;
            for(int j = 0; j < dp[i - 1].length(); j++) {
                char c = dp[i - 1].charAt(j);
                if (c != prev) {
                    dp[i].append(String.valueOf(count));
                    dp[i].append(prev);
                    prev = c;
                    count = 1;
                }
                else {
                    count++;
                }
                
                if (j == dp[i - 1].length() - 1) {
                    dp[i].append(String.valueOf(count));
                    dp[i].append(prev);
                }
            }
        }
        
        return dp[n].toString();
    }
}