public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        
        int row = triangle.size();
        if (row == 0) {
            return 0;
        }
        
        int[] sum = new int[row];
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++) {
            for(int j = i; j >= 0; j--) {
                if (j == 0) {
                    sum[j] = sum[j] + triangle.get(i).get(j);
                }
                else (j == i) {
                    sum[j] = sum[j - 1] + triangle.get(i).get(j);
                }
                else {
                    sum[j] = Math.min(sum[j-1], sum[j]) + triangle.get(i).get(j);
                }
                
                if (i == row - 1) 
                {
                    result = Math.min(result, sum[j]);
                }
            }
        }
        
        return result;
    }
}