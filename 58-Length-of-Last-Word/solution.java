public class Solution {
    public int lengthOfLastWord(String s) {
        /*
        if (s == null || s.length() == 0) {
            return 0;
        }    
        
        s = s.trim();
        int spaceIndex = s.lastIndexOf(" ");
        if (spaceIndex == -1) {
            return s.length();
        }
        else {
            return s.length() - spaceIndex - 1;
        }
        */
        
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int len = s.length();
        int res = 0;
        for(int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
            }
            else {
                if (res > 0) {
                    return res;
                }
            }
        }
        
        return res;
    }
}