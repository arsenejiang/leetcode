public class Solution {
    public int myAtoi(String str) {
        if(str == null) {
            return 0;
        }
        
        str = str.trim();
        int len = str.length();
        if (len == 0) {
            return 0;
        }
        
        int sign = 1;
        long num = 0;
        if (str.charAt(0) == '+') {
            sign = 1;
        }
        else if(str.charAt(0) == '-') {
            sign = -1;
        }
        else if (Character.isDigit(str.charAt(0))) {
            num = str.charAt(0) - '0';
        }
        else {
            return 0;
        }
        
        for(int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if(num > Integer.MAX_VALUE) {
                    break;
                }
            }
            else {
                break;
            }
        }
        
        num = num * sign;
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        else if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        else {
            return (int)num;
        }
    }
}