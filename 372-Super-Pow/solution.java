public class Solution {
    public int superPow(int a, int[] b) {
        long res = 1;
        for(int i = 0; i < b.length; i++) {
            res = pow(a, 10) * pow(a, b[i]) % 1337;
        }
        
        return (int)res;
    }
    
    private int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        
        if (x == 1) {
            return 1;
        }
        
        x = x % 1337;
        return pow(x, n / 2) * pow(x, n - n / 2) % 1337;
    }
}