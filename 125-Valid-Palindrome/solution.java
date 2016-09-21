public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            while (!Character.isDigit(arr[left]) && !Character.isLetter(arr[left])) {
                left++;
            }
            
            while (!Character.isDigit(arr[right]) && !Character.isLetter(arr[right])) {
                right--;
            }
            
            if (arr[left] != arr[right]) {
                left++;
                right--;
                return false;
            }
        }
        
        return true;
    }
}