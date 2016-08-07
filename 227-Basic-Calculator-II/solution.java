public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            
            if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                else if (sign == '-') {
                    stack.push(-1 * num);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                
                sign = c;
                num = 0;
            }
        }
        
        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}