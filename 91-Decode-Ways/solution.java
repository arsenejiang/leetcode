public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int len = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }
        
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = (i >= 2) ? dp[i-2] : 1;
                }
                else {
                    return 0;
                }
            }
            else {
                int val = Integer.valueOf(s.substring(i-1, i+1));
                if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && c <= '6')) {
                    dp[i] = dp[i - 1] + ((i >= 2) ? dp[i - 2] : 1);
                }
                else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        
        return dp[len - 1];
    }
}