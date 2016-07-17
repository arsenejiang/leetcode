public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        HashSet<String> visisted = new HashSet();
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            
            Set<String> temp = new HashSet();
            for(String s : beginSet) {
                char[] arr = s.toCharArray();
                for(int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String target = String.valueOf(arr);
                        if (endList.contains(target)) {
                            return len + 1;
                        }
                        
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                    }
                    arr[i] = old;
                }
            }
            beginSet = temp;
            len++;
        }
        
        return 0;
    }
}