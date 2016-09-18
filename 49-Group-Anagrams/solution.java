public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key)) {
                ArrayList<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            
            map.get(key).add(s);
        }
        
        for(List<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
}