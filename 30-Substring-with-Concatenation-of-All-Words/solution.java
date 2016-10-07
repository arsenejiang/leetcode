public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0 || words[0].length() == 0) {
            return res;
        }
        
        HashMap<String, Integer> wmap = new HashMap<String, Integer>();
        int wlen = words[0].length();
        int tlen = 0;
        int slen = s.length();
        for(String word : words) {
            tlen += wlen;
            if (!wmap.containsKey(word)) {
                wmap.put(word, 1);
            }
            else {
                wmap.put(word, wmap.get(word) + 1);
            }
        }
        
        for(int i = 0; i < wlen; i++) {
            int start = i, count = 0;
            HashMap<String, Integer> covered = new HashMap<String, Integer>();
            for(int j = i; j <= slen - wlen; j+=wlen) {
                String sub = s.substring(j, j + wlen);
                if (wmap.containsKey(sub)) {
                    if (covered.containsKey(sub)) {
                        count++;
                        covered.put(sub, covered.get(sub) + 1);
                    }
                    else {
                        count++;
                        covered.put(sub, 1);
                    }
                    
                    while(wmap.get(sub) < covered.get(sub)) {
                        String temp = s.substring(start, start + wlen);
                        start = start + wlen;
                        covered.put(temp, covered.get(temp) - 1);
                        count--;
                    }
                    
                    if (count == words.length) {
                        res.add(start);
                        String temp = s.substring(start, start + wlen);
                        covered.put(temp, covered.get(temp) - 1);
                        count--;
                        start = start + wlen;
                    }
                }
                else {
                    start = j + wlen;
                    covered.clear();
                    count = 0;
                }
            }
        }
        
        return res;
    }
}