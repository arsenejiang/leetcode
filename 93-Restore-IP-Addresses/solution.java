public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 4) {
            return res;
        }
        
        List<String> path = new ArrayList<String>();
        helper(s, 0, path, res);
        return res;
    }
    
    private void helper(String s, int start, List<String> path, List<String> res) {
        if (start == s.length() || path.size() >= 4) {
            if (start == s.length() && path.size() == 4) {
                StringBuilder sb = new StringBuilder(path.get(0));
                for(int i = 1; i < 4; i++) {
                    sb.append('.');
                    sb.append(path.get(i));
                }
                res.add(sb.toString());
            }
            return;
        }
        
        for(int j = start; j < s.length() && j < start + 3; j++) {
            if (s.charAt(start) == '0' && j > start) {
                break;
            }
            
            int val = Integer.valueOf(s.substring(start, j + 1));
            if (val >= 0 && val <= 255) {
                path.add(Integer.toString(val));
                helper(s, j + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}