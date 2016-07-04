public class Solution {
    public String simplifyPath(String path) {
        if (path == null) {
            return "";
        }
        
        String s = path.trim();
        int length = s.length();
        if (length == 0) {
            return "";
        }
        
        Stack<String> stack = new Stack<String>();
        int start = 0;
        boolean found = false;
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '/') {
                if (found) {
                    String cur = s.substring(start, i);
                    if (cur.equals(".")) {
                    }
                    else if (cur.equals("..")) {
                        stack.pop();
                    }
                    else {
                        stack.push(cur);
                    }
                }
                found = false;
            }
            else {
                if (!found) {
                    found = true;
                    start = i;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}