public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--) {
            if (isEmptyOrWhiteSpace(arr[i])) {
                continue;
            }
            
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
    
    private boolean isEmptyOrWhiteSpace(String str) {
        return str.length() == 0 || str.charAt(0) == ' ';
    }
}