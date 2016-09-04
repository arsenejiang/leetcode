public class Solution {
    public int lengthOfLastWord(String s) {
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
    }
}