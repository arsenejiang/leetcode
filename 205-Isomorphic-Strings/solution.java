public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        if (s.equals(t)) {
            return true;
        }
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
            else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                else {
                    map.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        
        return true;
    }
}