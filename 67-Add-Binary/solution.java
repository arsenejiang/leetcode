public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int i = aLen - 1;
        int j = bLen - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int aVal = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bVal = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = aVal + bVal + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        
        if (carry > 0) {
            sb.insert(0, '1');
        }
        
        return sb.toString();
    }
}