public class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        
        for(char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}