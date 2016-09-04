public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] flag = new boolean[len + 1];
        flag[0] = true;
        
        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < i; j++) {
                if (flag[j] && wordDict.contains(s.substring(j, i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        
        return flag[len];
    }
}