public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[i][j] = 0;
                }
                else {
                    heights[i][j] = (i == 0) ? 1 : heights[i-1][j] + 1;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < m; i++) {
            max = Math.max(max, maxRectangleInHistogram(heights[i]));
        }
        
        return max;
    }
    
    private int maxRectangleInHistogram(int[] heights) {
        /*
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            if (s.isEmpty() || h >= s.peek()) {
                s.push(i);
            }
            else {
                int index = s.pop();
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                max = Math.max(max, heights[index]*width);
                i--;
            }
        }
        
        return max;
        */
        
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}