public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        };
        
        Arrays.sort(strs, comp);
        
        for(int i = strs[0].length(); i >= 0; i--) {
            String prefix = strs[0].substring(0, i);
            int j = 0;
            for(j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    break;
                }
            }
            
            if (j == strs.length) {
                return prefix;
            }
        }
        
        return "";
    }
}