public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        
        int len = num.length();
        for(int i = 1; i <= len / 2; i++) {
            for(int j = i + 1; j <= len / 2 + i && j < len; j++) {
                if (isValid(num, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isValid(String num, int i, int j) {
        if (num.charAt(0) == '0' && i > 1) {
            return false;
        }
        
        if (num.charAt(i) == '0' && j > i + 1) {
            return false;
        }
        
        String sum;
        Long x1 = Long.valueOf(num.substring(0, i));
        Long x2 = Long.valueOf(num.substring(i, j));
        int len = num.length();
        for(int start = j; start < len; start += sum.length()) {
            x2 = x1 + x2;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        
        return true;
    }
}