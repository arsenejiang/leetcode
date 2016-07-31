public class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder r = new StringBuilder(s).reverse();
        sb.append('#');
        sb.append(r);
        
        int[] p = new int[sb.length()];
        for(int i = 1; i < sb.length(); i++) {
            int index = p[i-1];
            if (index > 0 && sb.charAt(i) != sb.charAt(index)) {
                index = p[index - 1];
            }
            
            if (sb.charAt(i) == sb.charAt(index)) {
                index++;
            }
            p[i] = index;
        }
        
        return r.substring(0, s.length() - p[sb.length() - 1]).toString() + s;
        
    }
}