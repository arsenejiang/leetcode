public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        
        s = s.trim();
        int len = s.length();
        if (len == 0) {
            return false;
        }
        
        boolean number = false;
        boolean e = false;
        boolean dot = false;
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = true;
            }
            else if (c == '.') {
                if (e == true || dot == true) {
                    return false;
                }
                dot = true;
            }
            else if (c == 'e') {
                if (e == true || number == false) {
                    return false;
                }
                e = true;
                number = false;
            }
            else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        return number;
    }
}