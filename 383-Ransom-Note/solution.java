public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() == 0)
            return false;
        }
        
        if (magazine.startsWith(ransomNote)) {
            return true;
        }
        
        int[] counts = new int[26];
        for(char c : magazine.toCharArray()) {
            counts[c-'a']++;
        }
        
        for(char c : ransomNote.toCharArray()) {
            if (--counts[c-'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}