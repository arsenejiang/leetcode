public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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
        
        return new ArrayList<List<String>>(map.values());
    }
}