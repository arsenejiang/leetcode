public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Set<String> set1 = new HashSet();
        Set<String> set2 = new HashSet();
        set1.add(beginWord);
        set2.add(endWord);
        
        Map<String, List<String>> map = new HashMap();
        buildMap(wordList, set1, set2, map, false);
        
        List<String> cur = new ArrayList();
        List<List<String>> res = new ArrayList();
        generateList(beginWord, endWord, map, cur, res);
        return res;
    }
    
    private void buildMap(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if(set1.isEmpty()) {
            return;
        }
        
        if (set1.size() > set2.size()) {
            buildMap(dict, set2, set1, map, !flip);
            return;
        }
        
        dict.removeAll(set1);
        dict.removeAll(set2);
        
        Set<String> next = new HashSet();
        for(String s : set1) {
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                char old = arr[i];
                for(char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String word = new String(arr);
                    String key = flip ? word : s;
                    String value = flip ? s : word;
                    
                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList();
                    
                    if (set2.contains(word)) {
                        list.add(value);
                        map.put(key, list);
                    }
                    else if (dict.contains(word)) {
                        next.add(word);
                        list.add(value);
                        map.put(key, list);
                    }
                }
                arr[i] = old;
            }
        }
        
        buildMap(dict, next, set2, map, flip);
    }
    
    private void generateList(String start, String end, Map<String, List<String>> map, List<String> cur, List<List<String>> res) {
        if (start.equals(end)) {
            res.add(new ArrayList(cur));
            return;
        }
        
        for(String word : map.get(start)) {
            cur.add(word);
            generateList(word, end, map, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    
}