public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList();
        if (s == null || s.length() < 10) {
            return res;
        }
        
        int len = s.length();
        Map<String, Integer> map = new HashMap();
        for(int i = 0; i <= len - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub)) {
                int count = map.get(sub) + 1;
                map.put(sub, count);
                if (count == 2) {
                    res.add(sub);
                }
            }
            else {
                map.put(sub, 1);
            }
        }
        
        return res;
    }
}