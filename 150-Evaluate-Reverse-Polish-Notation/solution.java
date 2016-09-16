public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (isInteger(tokens[i])) {
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
    
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}