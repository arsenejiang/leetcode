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
        
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i > end; i--) {
            sb.append(arr[i]);
        }
        sb.append(s);
        
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