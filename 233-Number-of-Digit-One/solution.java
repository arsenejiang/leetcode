public class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for(int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            ones += (a + 8) / 10 * m + (a % 10 == 1) ? b + 1 : 0;
        }
        
        return ones;
    }
}