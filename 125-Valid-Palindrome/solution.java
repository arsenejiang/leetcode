public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if (arr[left++] != arr[right--]) {
                return false;
            }
        }
        
        return true;
    }
}