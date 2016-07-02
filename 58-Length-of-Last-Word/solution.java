public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int len = s.length();
        boolean foundWord = false;
        int lastWordLength = 0;
        for(int i = len - 1; i >= 0; i--) {
            if (foundWord) {
                if (s.charAt(i) == ' ') {
                    return lastWordLength;
                }
                else {
                    lastWordLength++;
                }
            }
            else {
                if (s.charAt(i) != ' ') {
                    foundWord = true;
                    lastWordLength++;
                }
            }
        }
        
        return lastWordLength;
    }
}