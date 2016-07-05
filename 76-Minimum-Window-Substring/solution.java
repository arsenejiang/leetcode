public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        int sLen = s.length();
        int tLen = t.length();
        HashMap<Character, Integer> map = new HashMap();
        for(char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        
        HashMap<Character, Integer> coveredMap = new HashMap();
        int start = 0;
        int minStart = 0;
        int minEnd = 0;
        int match = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(coveredMap.containsKey(c)) {
                    if(coveredMap.get(c) < map.get(c)) {
                        match++;
                    }
                    coveredMap.put(c, coveredMap.get(c) + 1);
                }
                else {
                    coveredMap.put(c, 1);
                    match++;
                }
                
                while(match == tLen) {
                    if (i - start + 1 < minLen) {
                        minStart = start;
                        minEnd = i;
                        minLen = i - start + 1;
                    }
                    
                    char remove = s.charAt(start);
                    if(!map.containsKey(remove)) {
                        start++;
                    }
                    else {
                        if (coveredMap.get(remove) <= map.get(remove)) {
                            match--;
                        }
                        coveredMap.put(remove, coveredMap.get(remove) - 1);
                        start++;
                    }
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd + 1);
        
    }
}