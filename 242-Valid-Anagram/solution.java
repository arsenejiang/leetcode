public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        
        if (s.equals(t)) {
            return true;
        }
        
        int sLen = s.length();
        int tLen = t.length();
        
        if (sLen != tLen) {
            return false;
        }
        
        int[] count = new int[26];
        for(int i = 0; i < sLen; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < tLen; i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}