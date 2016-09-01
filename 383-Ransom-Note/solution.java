public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNode.length() == 0 || magazine.length() == 0) {
            return false;
        }
        
        int[] counts = new int[26];
        for(char c : magazine) {
            counts[c-'a']++;
        }
        
        for(char c : ransomNode) {
            if (--counts[c-'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}