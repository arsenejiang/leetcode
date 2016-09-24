public class Solution {
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for(String s : arr) {
            int level = s.lastIndexOf("\t") + 1;
            while(!stack.isEmpty() && level < stack.size()) {
                stack.pop();
            }
            
            int len = (stack.isEmpty() ? 0 : stack.peek()) + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        
        return res;
    }
}