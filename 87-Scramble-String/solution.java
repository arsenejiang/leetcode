public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        
        int len = s1.length();
        if (s1.equals(s2)) {
            return true;
        }
        
        if (len == 1) {
            return false;
        }
        else if (len == 2) {
            return s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0);
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < len; i++) {
            char c = s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        
        for(int i = 0; i < len; i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        for(int i = 1; i <= len; i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
            isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i))) {
                return true;
            }
        }
        
        return false;
    }
}