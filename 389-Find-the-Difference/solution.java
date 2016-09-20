public class Solution {
    public char findTheDifference(String s, String t) {
        /* hashMap
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if (!smap.containsKey(c)) {
                smap.put(c, 1);
            }
            else {
                smap.put(c, smap.get(c) + 1);
            }
        }
        
        for(char c : t.toCharArray()) {
            if (!smap.containsKey(c)) {
                return c;
            }
            else {
                int count = smap.get(c) - 1;
                if (count == 0) {
                    smap.remove(c);
                }
                else {
                    smap.put(c, count);
                }
            }
        }
        
        return 0;
        */
        
        char c = 0;
        for(int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
        }
        
        for(int i = 0; i < t.length(); i++) {
            c ^= t.charAt(i);
        }
        
        return c;
    }
}