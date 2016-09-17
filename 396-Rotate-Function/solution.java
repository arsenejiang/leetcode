public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;
        int allSum = 0;
        int start = 0;
        for(int i = 0; i < A.length; i++) {
            start += (i * A[i]);
            allSum += A[i];
        }
        
        int max = start;
        for(int i = 0; i < A.length - 1; i++) {
            start = start - allSum + len * A[i];
            max = Math.max(max, start);
        }
        
        return max;
    }
}
