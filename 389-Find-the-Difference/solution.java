public class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if (!smap.containsKey(c)) {
                smap.put(c, 1);
            }
            else {
                smap.put(c, smap.get(c) + 1);
            }
        }
        
        for(char c : t.CharArray()) {
            if (!smap.containsKey(c)) {
                return c;
            }
            else {
                int count = smap.get(c) - 1;
                if (count == 0) {
                    smap.remove(c);
                }
            }
        }
        
        return '0';
    }
}