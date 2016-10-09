public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict.size() == 0) {
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return helper(s, wordDict, map);
    }
    
    private List<String> helper(String s, Set<String> wordDict, HashMap<String, List<String>> map) {
        List<String> res = new ArrayList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if (wordDict.contains(temp)) {
                List<String> rest = helper(s.substring(i), wordDict, map);
                for(String str : rest) {
                    if (str.length() == 0) {
                        res.add(temp);
                    }
                    else {
                        res.add(temp + " " + str);
                    }
                }
            }
        }
        
        map.put(s, res);
        return res;
    }
}