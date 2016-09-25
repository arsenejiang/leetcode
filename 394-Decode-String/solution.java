public class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        Stack<Integer> counts = new Stack<Integer>();
        Stack<String> result = new Stack<String>();
        int i = 0;
        String str = "";
        while(i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int count = 0;
                while(Character.isDigit(s.charAt(i))) {
                    count = count * 10 + s.charAt(i) - '0';
                    i++;
                }
                counts.push(count);
            }
            else if (c == '[') {
                result.push(str);
                str = "";
                i++;
            }
            else if (c == ']') {
                int repeatTimes = counts.pop();
                StringBuilder sb = new StringBuilder(result.pop());
                for(int j = 0; j < repeatTimes; j++) {
                    sb.append(str);
                }
                str = sb.toString();
                i++;
            }
            else {
                str = str + c;
                i++;
            }
        }
        
        return str;
        
    }
}