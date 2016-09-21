public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if (!Character.isLetterOrDigit(arr[left])) {
                left++;
            }
            else if (!Character.isLetterOrDigit(arr[right])) {
                right--;
            }
            else if (Character.toLowerCase(arr[left++]) != Character.toLowerCase(arr[right--])) {
                return false;
            }
        }
        
        return true;
    }
}