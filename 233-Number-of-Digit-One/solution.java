public class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for(long m = 1; m <= n; m *= 10) {
            
            // m = 1, (n / m + 8) / 10 to indicate how many counts of 10 (0-9), each one will have 1 DigitOne in the last digit
            // m = 10, (n / m + 8) / 10 to indicate how many counts of 100 (00-99), each one will have 10 DigitOne in the tens digit
            // m = 100, (n / m + 8) / 10 to indicate how many counts of 1000 (000-999), each one will have 100 DigitOne in the hundreds digit
            // (n / m + 8) to separate the cases between (0, 1) and 2. 2 will have the full steak.
            ones += (n / m + 8) / 10 * m;
            
            // n / m % 10 == 1 to check if the digit is 1
            ones += (n / m % 10 == 1) ? n % m + 1 : 0;
        }
        
        return ones;
    }
}