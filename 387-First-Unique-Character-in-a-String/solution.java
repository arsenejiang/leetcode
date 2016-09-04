public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int len = s.length();
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for(int i = 0; i < len; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}