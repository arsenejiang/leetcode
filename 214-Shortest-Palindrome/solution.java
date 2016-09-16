public class Solution {
    public String shortestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int index = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            if (isPalindrome(arr, 0, i)) {
                index = i;
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i > index; i--) {
            sb.append(arr[i]);
        }
        sb.append(s);
        return sb.toString();
    }
    
    private boolean isPalindrome(char[] arr, int left, int right) {
        while(left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}