public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList();
        Queue<String> q = new LinkedList();
        Set<String> set = new HashSet();
        q.offer(s);
        set.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            String str = q.poll();
            if (isValid(str)) {
                set.add(str);
                res.add(str);
                found = true;
            }
            
            if (found) {
                continue;
            }
            
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }
                String newStr = str.substring(0, i) + str.substring(i+1, str.length());
                if (!set.contains(newStr)) {
                    set.add(newStr);
                    q.offer(newStr);
                }
            }
        }
        
        return res;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        
        return count == 0;
    }
}