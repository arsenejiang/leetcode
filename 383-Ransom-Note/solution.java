public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int rlen = ransomNote.length();
        int mlen = magazine.length();
        if (rlen > mlen) {
            return false;
        }
        
        int[] count = new int[26];
        for(char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        
        for(char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}