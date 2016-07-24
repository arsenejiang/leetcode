public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int endIndex = -1;
        for(int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if(endIndex != -1) {
                    if (sb.length() != 0) {
                        sb.append(' ');
                    }
                    sb.append(s.substring(i + 1, endIndex + 1));
                    endIndex = -1;
                }
            }
            else {
                if (endIndex == -1) {
                    endIndex = i;
                }
            }
        }
        
        if (endIndex != -1) {
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(s.substring(0, endIndex + 1));
        }
        
        return sb.toString();
    }
}