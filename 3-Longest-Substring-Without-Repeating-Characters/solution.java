public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int res = 0;
        int cur = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int prevIndex = map.get(c);
                cur = i - prevIndex;
                res = Math.max(res, cur);
                map.put(c, i);
            }
            else {
                cur++;
                res = math.max(res, cur);
                map.put(c, i);
            }
        }
        
        res = Math.max(res, cur);
        return res;
    }
}