public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i].charAt(0))) {
                stack.push(Integer.valueOf(tokens[i]));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();
                if (tokens[i].equals("+")) {
                    stack.push(a + b);
                }
                else if (tokens[i].equals("-")) {
                    stack.push(a - b);
                }
                else if (tokens[i].equals("*")) {
                    stack.push(a * b);
                }
                else if (tokens[i].equals("/")) {
                    stack.push(a / b);
                }
            }
        }
        
        return stack.peek();
    }
}