public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int rowBegin = 0, rowEnd = m - 1, colBegin = 0, colEnd = n - 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse from left to right
            for(int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            
            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }
        
        return res;
    }
}