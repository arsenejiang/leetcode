public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        Set<String> set = new HashSet<String>(wordDict);
        return helper(s, 0, s.length() - 1, set);
    }
    
    private boolean helper(String s, int start, int end, Set<String> set) {
        if (set.contains(s.substring(start, end + 1))) {
            return true;
        }
        
        for(int i = end - 1; i >= start; i--) {
            if (helper(s, start, i, set) && helper(s, i + 1, end, set)) {
                set.add(s.substring(start, end + 1));
                return true;
            }
        }
        
        return false;
    }
}