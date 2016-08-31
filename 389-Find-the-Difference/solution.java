public class Solution {
    /*
    // array solution (6ms)
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
    */
    
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(char c : s.toCharArray()) {
            res ^= c;
        }
        
        for(char c : t.toCharArray()) {
            res ^= c;
        }
        
        return res;
    }
}