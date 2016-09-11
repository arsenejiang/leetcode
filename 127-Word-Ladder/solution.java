public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> beginSet = new HashSet<String>();
        HashSet<String> endSet = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
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
                        if (c == old) {
                            continue;
                        }
                        
                        arr[i] = c;
                        String newString = new String(arr);
                        if (wordList.contains(newString)) {
                            if (endSet.contains(newString)) {
                                return len + 1;
                            }
                            else {
                                temp.add(newString);
                            }
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