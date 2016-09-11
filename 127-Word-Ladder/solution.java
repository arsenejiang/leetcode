public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> beginSet = new HashSet<String>();
        HashSet<String> endSet = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        HashSet<String> visited = new HashSet<String>();
        while(!beginSet.isEmpty() || !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            HashSet<String> temp = new HashSet<String>();
            for(String s : beginSet) {
                char[] arr = s.toCharArray();
                for(int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newString = new String(arr);
                        if (endSet.contains(newString)) {
                            return len + 1;
                        }
                        
                        if (!visited.contains(newString) && wordList.contains(newString)) {
                            temp.add(newString);
                            visited.add(newString);
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