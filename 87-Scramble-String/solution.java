public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        
        if (s1.equals(s2)) {
            return true;
        }
        
        for(int i = 1; i < len1; i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len1), s2.substring(i))) ||
            (isScramble(s1.substring(0, i), s2.substring(len1-i, len1)) && isScramble(s1.substring(i, len1), s2.substring(0, len1-i))))
            {
                return true;
            }
        }
        
        return false;
    }
}