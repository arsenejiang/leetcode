public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n <= 0) {
            return res;
        }
        else if (n == 1) {
            res[0][0] = 1;
            return res;
        }
        
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
            // if (colEnd >= colBegin) {
                for(int i = colEnd; i >= colBegin; i--) {
                    res[rowEnd][i] = cur++;                    
                }
                rowEnd--;
            // }
            
            // if (rowEnd >= rowBegin) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    res[i][colBegin] = cur++;
                }
                colBegin++;
             // }
        }
        
        return res;
    }
}