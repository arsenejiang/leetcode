public class Solution {
    public String shortestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int end = arr.length - 1;
        while(end > 0) {
            if (isPalindrome(arr, end)) {
                break;
            }
            end--;
        }
        
        StringBuilder sb = new StringBuilder(s);
        for(int i = end + 1; i < arr.length; i++) {
            sb.insert(0, arr[i]);
        }
        
        return sb.toString();
    }
    
    private boolean isPalindrome(char[] arr, int end) {
        int start = 0;
        while(start < end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }
        
        return true;
    }
}