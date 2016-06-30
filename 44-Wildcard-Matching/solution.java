public class Solution {
    public boolean isMatch(String s, String p) {
        int sp = 0, pp = 0;
        int starIndex = -1, match = 0;
        int sLen = s.length();
        int pLen = p.length();
        while(sp < sLen) {
            if (pp < pLen && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                pp++;
                sp++;
            }
            else if (pp < pLen && p.charAt(pp) == '*') {
                starIndex = pp;
                pp++;
                match = sp;
            }
            else if (starIndex != -1) {
                pp = starIndex + 1;
                match++;
                sp = match;
            }
            else {
                return false;
            }
        }
        
        while(pp < pLen && p.charAt(pp) == '*') {
            pp++;
        }
        
        return pp == pLen;
    }
}