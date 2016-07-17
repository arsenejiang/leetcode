public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        
        int len = s.length();
        int left = 0, right = len - 1;
        while(left < right) {
            while(s.charAt(left) == ' ') {
                left++;
            }
            
            while(s.charAt(right) == ' ') {
                right++;
            }
            
            if (left < right) {
                if (s.charAt(left) == s.charAt(right) || 
                (Math.abs(s.charAt(left) - s.charAt(right)) == 'a' - 'A') && ((s.charAt(left) <= 'Z' && s.charAt(left) >= 'A') || (s.charAt(left) <= 'z' && s.charAt(left) >= 'a'))) {
                    left++;
                    right++;
                    continue;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
        
        return true;
    }
}