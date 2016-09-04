public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        else if (b == null || b.isEmpty()) {
            return a;
        }
        
        StringBuilder sb = new StringBuilder();
        int m = a.length();
        int n = b.length();
        int carry = 0;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 || j >= 0) {
            int val = carry;
            val += (i >= 0) ? a.charAt(i) - '0' : 0;
            val += (j >= 0) ? b.charAt(j) - '0' : 0;
            char c = (char)('0' + val % 2);
            sb.append(c);
            carry = val / 2;
            i--;
            j--;
        }
        
        if (carry > 0) {
            char c = (char)('0' + carry);
            sb.append(c);
        }
        
        return sb.reverse().toString();
    }
}