public class Solution {
    public int superPow(int a, int[] b) {
        a = a % 1337;
        if (a == 0) {
            return 0;
        }
        else if (a == 1) {
            return 1;
        }
        
        long result = 1;
        int multi = 1;
        for(int i = b.length - 1; i >= 0; i--) {
            result *= Math.pow(a, multi * b[i]);
            multi = multi * 10;
        }
        
        result = result % 1337;
        
        return result;
    }
}