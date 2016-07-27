public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        
        int step = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            step++;
        }
        
        return m << step;
    }
}