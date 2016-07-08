public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> s = new Stack();
        int result = 0;
        for(int i = 0; i < heights.length; i++) {
            if (s.isEmpty() || heights[i] >= heights[s.peek()]) {
                s.push(i);
            }
            else {
                while(!s.isEmpty() && heights[i] < heights[s.peek()]) {
                    int index = s.pop();
                    int width = s.isEmpty() ? i : i - 1 - s.peek();
                    result = Math.max(result, heights[index]*width);
                }
                s.push(i);
            }
        }
        
        while(!s.isEmpty()) {
            int index = s.pop();
            int width = s.isEmpty() ? heights.length : heights.length - 1 - s.peek();
            result = Math.max(result, heights[index]*width);
        }
        
        return result;
    }
}