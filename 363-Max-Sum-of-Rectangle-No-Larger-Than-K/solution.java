public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for(int l = 0; l < n; l++) {
            int[] sums = new int[n];
            for(int r = l; r < n; r++) {
                for(int i = 0; i < m; i++) {
                    sums[i] += matrix[i][r];
                }
                
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                
                int curSum = 0;
                for(int sum : sums) {
                    curSum += sum;
                    Integer num = set.ceiling(curSum - k);
                    if (num != null) {
                        res = Math.max(res, curSum - num);
                    }
                    set.add(curSum);
                }
            }
        }
        
        return res;
    }
}