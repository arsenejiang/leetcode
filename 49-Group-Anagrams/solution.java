public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        HashMap<String, List<String>> map = new HashMap();
        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            }
            else {
                ArrayList<String> newList = new ArrayList();
                newList.add(s);
                map.put(key, newList);
            }
        }
        
        for(List<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
}