public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        
        int match = 0;
        int[] result = new int[]{0, s.length()};
        
        int start = 0;
        for(start = 0; start < s.length(); start++) {
            if (map.containsKey(s.charAt(start))) {
                break;
            }
        }
        
        if (start == s.length()) {
            return "";
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                continue;
            }
            
            map.put(c, map.get(c) - 1);
            if (map.get(c) <= 0) {
                if (map.get(c) == 0) {
                    match++;
                }
                
                if (match == map.size()) {
                    while(!map.containsKey(s.charAt(start)) || map.get(s.charAt(start)) < 0) {
                        if (map.containsKey(s.charAt(start))) {
                            map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                        }
                        start++;
                    }
                    
                    if ((i - start) < (result[1] - result[0])) {
                        result[0] = start;
                        result[1] = i;
                    }
                }
            }
        }
        
        if (result[1] - result[0] == s.length()) {
            return "";
        }
        else {
            return s.substring(result[0], result[1] + 1);
        }
    }
}