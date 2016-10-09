public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() <= 9) {
            return res;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i <= s.length() - 10; i++) {
            int val = strToInt(s.substring(i, i + 10));
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
                if (map.get(val) == 2) {
                    res.add(s.substring(i, i + 10));
                }
            }
            else {
                map.put(val, 1);
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