public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                int result;
                if (s.equals("+")) {
                    result = first + second;
                }
                else if (s.equals("-")) {
                    result = first - second;
                }
                else if (s.equals("*")) {
                    result = first * second;
                }
                else {
                    result = first / second;
                }
                stack.push(result);
            }
            else {
                stack.push(Integer.valueOf(s));
            }
        }
        
        return stack.peek();
    }
}