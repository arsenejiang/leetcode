public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList();
        if (s == null || s.length() < 10) {
            return res;
        }
        
        int len = s.length();
        Map<Character, Integer> map = new HashMap();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        Set<Integer> words = new HashSet();
        Set<Integer> doubleWords = new HashSet();
        int max = 0xFFFFF;
        int hash = 0;
        for(int i = 0; i < len; i++) {
            if (i < 9) {
                hash = (hash << 2) + map.get(s.charAt(i));
            }
            else {
                hash = (hash << 2) + map.get(s.charAt(i));
                hash = hash & max;
                if (!words.add(hash) && doubleWords.add(hash)) {
                    res.add(s.substring(i - 9, i + 1));
                }
            }
        }
        
        return res;
    }
}