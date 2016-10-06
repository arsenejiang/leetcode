public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }
        
        int gap = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i = 0; i < numRows; i++) {
            j = i;
            boolean odd = true;
            int curGap = gap - i * 2;
            while(j < s.length()) {
                sb.append(s.charAt(j));
                if (i == 0 || i == numRows - 1) {
                    j = j + gap;
                }
                else {
                    j = j + curGap;
                    curGap = gap - curGap;
                }
            }
        }
        
        return sb.toString();
    }
}