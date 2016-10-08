public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int index1 = i + j;
                int index2 = i + j + 1;
                int sum = val + pos[index2];
                pos[index1] += sum / 10;
                pos[index2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m + n; i++) {
            if (sb.length() == 0 && pos[i] == 0) {
                continue;
            }
            else {
                sb.append(pos[i]);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}