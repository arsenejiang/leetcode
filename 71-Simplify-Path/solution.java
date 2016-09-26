public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (arr[i].equals(".")) {
                continue;
            }
            else if (arr[i].length() > 0) {
                stack.push(arr[i]);
            }
        }
        
        if (stack.size() == 0) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        
        return sb.toString();
    }
}