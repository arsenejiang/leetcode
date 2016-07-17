public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        
        int len = s.length();
        int left = 0, right = len - 1;
        while(left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left)) {
                left++;
            }
            else if (Character.isLetterOrDigit(s.charAt(right)) {
                right--;
            }
            else {
                if(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                    left++;
                    right--;
                }
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
}