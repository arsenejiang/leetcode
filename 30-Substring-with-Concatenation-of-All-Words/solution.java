public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        
        int sLen = s.length();
        int wLen = words[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String w : words) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            }
            else {
                map.put(w, 1);
            }
        }
        
        for(int i = 0; i < wLen; i++) {
            HashMap<String, Integer> covered = new HashMap<String, Integer>();
            int start = i;
            int count = 0;
            for(int j = i; j <= sLen - wLen; j += wLen) {
                String sub = s.substring(j, j + wLen);
                if (map.containsKey(sub)) {
                    if (covered.containsKey(sub)) {
                        covered.put(sub, covered.get(sub) + 1);
                    }   
                    else {
                        covered.put(sub, 1);
                    }
                    count++;
                    
                    while(map.get(sub) < covered.get(sub)) {
                        String temp = s.substring(start, start + wLen);
                        covered.put(temp, covered.get(temp) - 1);
                        count--;
                        start = start + wLen;
                    }
                    
                    if (count == words.length) {
                        res.add(start);
                        String temp = s.substring(start, start + wLen);
                        covered.put(temp, covered.get(temp) - 1);
                        count--;
                        start = start + wLen;
                    }
                }
                else {
                    start = j + wLen;
                    covered.clear();
                    count = 0;
                }
            }
        }
        
        return res;
        
    }
}