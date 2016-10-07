public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<String> res = new ArrayList<String>();
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
            int left = i;
            for(int j = i; )
        }
    }
}