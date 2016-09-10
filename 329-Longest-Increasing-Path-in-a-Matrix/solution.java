public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }   
        
        int[] res = new int[1];
        res[0] = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                helper(matrix, Integer.MIN_VALUE, i, j, 0, res);
            }
        }
        
        return res[0];
    }
    
    private void helper(int[][] matrix, int prev, int row, int col, int cur, int[] res) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || prev >= matrix[row][col]) {
            return;
        }
        
        res[0] = Math.max(res[0], cur + 1);
        helper(matrix, matrix[row][col], row - 1, col, cur + 1, res);
        helper(matrix, matrix[row][col], row + 1, col, cur + 1, res);
        helper(matrix, matrix[row][col], row, col - 1, cur + 1, res);
        helper(matrix, matrix[row][col], row, col + 1, cur + 1, res);
    }
}