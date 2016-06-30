public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1 || matrix[0].length <= 1) {
            return;
        }
        
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - i - 1; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[n - j - 1][i];
                nums[n - j - 1][i] = nums[n - i - 1][n - j - 1];
                nums[n - i - 1][n - j - 1] = nums[j][n - i - 1];
                nums[j][n - i - 1] = temp;
            }
        }
    }
}