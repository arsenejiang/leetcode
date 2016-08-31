public class Solution {
    public int superPow(int a, int[] b) {
        int res = 1;
        for(int i = 0; i < b.length; i++) {
            res = pow(res, 10) * pow(a, b[i]) % 1337;
        }
        
        return res;
    }
    
    private int pow(int a, int b) {
        if (a == 0) {
            return 0;
        }
        
        if (a == 1) {
            return 1;
        }
        
        a = a % 1337;
        int res = 1;
        while(b-- > 0) {
            res = res * a % 1337;
        }
        
        return res;
    }
}