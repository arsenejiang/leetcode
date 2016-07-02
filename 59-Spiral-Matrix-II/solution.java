public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int cur = 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            for(int i = colBegin; i <= colEnd; i++) {
                res[rowBegin][i] = cur++;
            }
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = cur++;
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--) {
                    res[rowEnd][i] = cur++;
                }
                rowEnd--;
            }
            if (colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    res[i][colBegin] = cur++;
                }
                colBegin++;
            }
        }
        
        return res;
    }
}