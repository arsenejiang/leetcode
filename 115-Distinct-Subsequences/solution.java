public class Solution {
    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen < tlen) {
            return 0;
        }
        else if (slen == tlen) {
            if (s.equals(t)) {
                return 1;
            }
            else {
                return 0;
            }
        }
        
        int[][] dp = new int[slen + 1][tlen + 1];
        for(int i = 0; i <= slen; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= slen; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i][j] = (s.charAt(i) == t.charAt(j)) ? dp[i-1][j-1] + dp[i-1][j] : dp[i-1][j];
            }
        }
        
        return dp[slen][tlen];
    }
}