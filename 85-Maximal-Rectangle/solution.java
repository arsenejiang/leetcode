public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n+1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[i][j] = 0;
                }
                else {
                    heights[i][j] = i == 0 ? 1 : heights[i-1][j] + 1;
                }
            }
        }
        
        int result = 0;
        for(int i = 0; i < m; i++) {
            result = Math.max(result, maximalRectangleInHistogram(heights[i]));
        }
        
        return result;
    }
    
    private int maximalRectangleInHistogram(int[] heights) {
        int result = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < heights.length; i++) {
            if (s.isEmpty() || heights[i] >= heights[s.peek()]) {
                s.push(i);
            }
            else {
                while(!s.isEmpty() && heights[i] < heights[s.peek()]) {
                    int index = s.pop();
                    int width = i - 1 - s.peek();
                    result = Math.max(result, heights[index]*width);
                }
                s.push(i);
            }
        }
        
        return result;
    }
}