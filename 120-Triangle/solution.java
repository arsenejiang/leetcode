public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(triangle, 0, 0);
    }
    
    private int helper(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        
        return triangle.get(row).get(col) + Math.min(helper(triangle, row + 1, col), helper(triangle, row + 1, col + 1));
    }
}