public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        if(s == null || s.length() == 0) {
            return res;
        }
        
        helper(s, 0, res, new ArrayList<String>());
        return res;
    }
    
    private void helper(String s, int start, List<List<String>> res, List<String> cur) {
        int len = s.length();
        if (start == len) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        
        for(int i = start; i < len; i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                cur.add(sub);
                helper(s, i + 1, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        
        return true;
    }
}