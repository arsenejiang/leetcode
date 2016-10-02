public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int res = 0;
        int cur = 0;
        int startIndex = -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= startIndex) {
                int prevIndex = map.get(c);
                cur = i - prevIndex;
                startIndex = prevIndex + 1;
                res = Math.max(res, cur);
                map.put(c, i);
            }
            else {
                cur++;
                res = Math.max(res, cur);
                map.put(c, i);
            }
        }
        
        res = Math.max(res, cur);
        return res;
    }
}