public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            int cur = 0;
            for(int j = 0; j < A.length; j++) {
                cur += ((i + j) % A.length) * A[j];
            }
            max = Math.max(cur, max);
        }
        
        return max;
    }
}
