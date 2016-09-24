public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while(left < right) {
            char c = arr[left];
            arr[left] = arr[right];
            arr[right] = c;
            left++;
            right--;
        }
        
        return new String(arr);
    }
}