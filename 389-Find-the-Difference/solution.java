public class Solution {
    public char findTheDifference(String s, String t) {
        int[] scounts = new int[26];
        for(char c : s.toCharArray()) {
            scounts[c - 'a']++;
        }
        
        for(char c : t.toCharArray()) {
            if (--scounts[c - 'a'] < 0) {
                return c;
            }
        }
        
        return 0;
    }
}