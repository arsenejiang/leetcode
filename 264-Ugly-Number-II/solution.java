public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int two = 0, three = 0, five = 0;
        for(int i = 1; i < n; i++) {
            res[i] = Math.min(Math.min(res[two]*2, res[three]*3), res[five]*5);
            if (res[i] == res[two]*2) {
                two++;
            }
            
            if (res[i] == res[three]*3) {
                three++;
            }
            
            if (res[i] == res[five]*5) {
                five++;
            }
        }
        
        return res[n-1];
    }
}