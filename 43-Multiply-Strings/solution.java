public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int val = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                int lp = i + j + 1;
                int hp = i + j;
                int sum = val + res[lp];
                res[lp] = sum % 10;
                res[hp] += sum / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++) {
            if (res[i] != 0 || sb.length() != 0) {
                sb.append(res[i]);
            }
        }
        
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}