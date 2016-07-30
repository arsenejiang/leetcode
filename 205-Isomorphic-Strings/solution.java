public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        
        Map<Character, Character> map = new HashMap();
        for(int i = 0; i < sLen; i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if (map.containsKey(schar) || map.containsValue(tchar)) {
                if (map.get(schar) == tchar) {
                    continue;
                }
                else {
                    return false;
                }
            }
            else {
                map.put(schar, tchar);
            }
        }
        
        return true;
    }
}