public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= l1; i++) {
            if (dp[i-1][0] == true) {
                dp[i][0] = (s1.charAt(i-1) == s3.charAt(i-1));
            }
        }
        
        for(int j = 1; j <= l2; j++) {
            if (dp[0][j - 1] == true) {
                dp[0][j] = (s2.charAt(j-1) == s3.charAt(j-1));
            }
        }
        
        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if (dp[i-1][j] == true) {
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i + j - 1));
                }
                
                if (dp[i][j] != true && dp[i][j-1] == true) {
                    dp[i][j] = (s2.charAt(j-1) == s3.charAt(i + j - 1));
                }
            }
        }
        
        return dp[l1][l2];
    }
}