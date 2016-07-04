public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList();
        if (words == null || words.length == 0) {
            return res;
        }
        
        int w = 0;
        for(int i = 0; i < words.length; i = w) {
            int sum = -1;
            for(w = i; w < words.length && sum + 1 + words[w].length() <= maxWidth; w++) {
                sum += 1 + words[w].length();
            }
            
            int space = 1, extra = 0;
            if (w != i + 1 && w < words.length) {
                space = (maxWidth - sum) / (w - i - 1) + 1;
                extra = (maxWidth - sum) % (w - i - 1);
            }
            
            StringBuilder sb = new StringBuilder(words[i]);
            for(int k = i+1; k < w; k++) {
                for(int l = 0; l < space; l++) {
                    sb.append(' ');
                }
                if (extra-- > 0) {
                    sb.append(' ');
                }
                sb.append(words[k]);
            }
            
            int strLen = maxWidth - sb.length();
            while(strLen-- > 0) {
                sb.append(' ');
            }
            
            res.add(sb.toString());
        }
        return res;
    }
}