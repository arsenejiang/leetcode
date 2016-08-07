public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            }
            else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if (c == ')') {
                result += sign * num;
                result = result * stack.pop();
                result += stack.pop();
                num = 0;
                sign = 1;
            }
        }
        
        result += sign * num;
        return result;
    }
}