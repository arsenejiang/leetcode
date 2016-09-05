public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        int maxLen = 0;
        int maxStart = -1;
        int maxEnd = -1;
        for(int i = 0; i <= s.length() - 2; i++) {
            int j = 1;
            while(i - j >= 0 && i + j <= s.length() - 1 && s.charAt(i-j) == s.charAt(i+j)) {
                j++;
            }
            
            if (2 * (j - 1) + 1 > maxLen) {
                maxLen = 2 * (j - 1) + 1;
                maxStart = i - j + 1;
                maxEnd = i + j - 1;
            }
            
            if (s.charAt(i) == s.charAt(i+1)) {
                j = 1;
                while(i - j >= 0 && i + 1 + j <= s.length() - 1 && s.charAt(i-j) == s.charAt(i+1+j)) {
                    j++;
                }
                
                if (2 * (j - 1) + 2 > maxLen) {
                    maxLen = 2 * (j - 1) + 2;
                    maxStart = i - j + 1;
                    maxEnd = i + j;
                }
            }
        }
        
        return s.substring(maxStart, maxEnd + 1);
    }
}