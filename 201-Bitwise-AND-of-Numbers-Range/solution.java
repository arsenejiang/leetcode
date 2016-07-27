public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        
        while(n > m) {
            n = n & (n - 1);
        }
        
        return m & n;
    }
}