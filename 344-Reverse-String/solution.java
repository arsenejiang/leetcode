public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        int low = 0;
        int high = arr.length - 1;
        while(low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        
        return new String(arr);
    }
}