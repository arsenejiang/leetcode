public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        
        s = s.trim();
        int size = s.length();
        boolean foundDot = false;
        boolean founde = false;
        boolean foundNumber = false;
        for(int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                foundNumber = true;
            }
            else if (c == 'e') {
                if (founde || !foundNumber) {
                    return false;
                }
                
                founde = true;
                foundNumber = false;
            }
            else if (c == '.') {
                if (founde || foundDot) {
                    return false;
                }
                foundDot = true;
            }
            else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        return foundNumber;
    }
}