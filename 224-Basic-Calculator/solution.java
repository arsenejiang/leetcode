public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int num = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            }
            else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            }
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                num = 0;
            }
            else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        
        if(num != 0) result += sign * num;
        return result;
    }
}