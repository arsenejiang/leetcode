public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 0;
        
        int maxLen = 0;
        for(int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i] = 0;
            }
            else {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                    maxLen = Math.max(dp[i], maxLen);
                }
                else {
                    int prevIndex = i - 1 - dp[i-1];
                    if (prevIndex >= 0 && s.charAt(prevIndex) == '(') {
                        dp[i] = dp[i-1] + 2 + (prevIndex >= 1 ? dp[prevIndex - 1] : 0);
                        maxLen = Math.max(dp[i], maxLen);
                    }
                    else {
                        dp[i] = 0;
                    }
                }
            }
        }
        
        return maxLen;
    }
}