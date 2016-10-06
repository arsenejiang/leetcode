public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        if (plen == 0) {
            return slen == 0;
        }
        
        if (plen == 1) {
            return slen == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        
        if (p.charAt(1) != '*') {
            if (slen == 0) {
                return false;
            }
            else {
                if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                    return isMatch(s.substring(1), p.substring(1));
                }
                else {
                    return false;
                }
            }
        }
        else {
            // next char is '*'
            while(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }
}