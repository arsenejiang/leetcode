public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        return helper(s, wordDict, map);
    }
    
    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> res = new ArrayList();
        if (wordDict.contains(s)) {
            res.add(s);
        }
        
        int len = s.length();
        for(int i = 1; i < len; i++) {
            String sub = s.substring(i);
            if (wordDict.contains(sub)) {
                List<String> list = helper(s.substring(0, i), wordDict, map);
                for(String str : list) {
                    res.add(str + " " + sub);
                }
            }
        }
        
        map.put(s, res);
        return res;
    }
}