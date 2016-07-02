public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int len = s.length();
        boolean foundWord = false;
        int lastWordLength = 0;
        for(int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lastWordLength++;
            }
            else {
                if (lastWordLength > 0) {
                    return lastWordLength;
                }
            }
        }
        
        return lastWordLength;
    }
}