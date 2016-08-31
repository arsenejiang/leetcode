public class Solution {
    public char findTheDifference(String s, String t) {
        int[] scounts = new int[26];
        for(char c : s.toCharArray()) {
            scounts[c - 'a']++;
        }
        
        char res = 0;
        for(char c : t.toCharArray()) {
            if (scounts[c - 'a'] == 0) {
                res = c;
                break;
            }
            
            scounts[c - 'a']--;
        }
        
        return res;
    }
}