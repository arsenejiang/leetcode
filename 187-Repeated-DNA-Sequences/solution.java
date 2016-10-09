public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() <= 9) {
            return res;
        }
        
        int len = s.length();
        HashMap<Character, Integer> cmap = new HashMap<Character, Integer>();
        cmap.put('A', 0);
        cmap.put('C', 1);
        cmap.put('G', 2);
        cmap.put('T', 3);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int hash = 0;
        int max = 0xFFFFF;
        for(int i = 0; i < len; i++) {
            if (i < 9) {
                hash = (hash << 2) + cmap.get(s.charAt(i));
            }
            else {
                hash = (hash << 2) + cmap.get(s.charAt(i));
                hash = hash & max;
                
                if (map.containsKey(hash)) {
                    map.put(hash, map.get(hash) + 1);
                    if (map.get(hash) == 2) {
                        res.add(s.substring(i - 9, i + 1));
                    }
                }
                else {
                    map.put(hash, 1);
                }
            }
        }
        
        return res;
    }
    
    private int strToInt(String s) {
        int res = 0;
        for(int i = 0; i < 10; i++) {
            char c = s.charAt(i);
            res = res << 2;
            switch (c) {
                case 'A':
                    res = res;
                    break;
                case 'C':
                    res = res + 1;
                    break;
                case 'G':
                    res = res + 2;
                    break;
                case 'T':
                    res = res + 3;
                    break;
            }
        }
        
        return res;
    }
}