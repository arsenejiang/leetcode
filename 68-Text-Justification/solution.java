public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList();
        if (words == null || words.length == 0) {
            return res;
        }
        
        int len = words.length;
        int i = 0;
        while(i < len) {
            int sum = 0;
            int j = i;
            for(; j < len && sum <= maxWidth; j++) {
                if (j != i) {
                    sum += 1;
                }
                sum += words[j].length();
            }
            
            StringBuilder sb = new StringBuilder(words[i]);
            
            if (sum > maxWidth) {
                j--;
                sum = sum - 1 - words[j].length();
            }
            
            int spaces = maxWidth - sum;
            int spaceLen = spaces / (j - i);
            int index = spaces % (j - i);
            for(int k = i+1; k <= j; k++) {
                for(int l = 0; l < spaceLen; l++) {
                    sb.append(' ');
                }
                if (index-- > 0) {
                    sb.append(' ');
                }
                sb.append(words[k]);
            }
            
            int strLen = maxWidth - sum;
            while(strLen-- > 0) {
                str.append(' ');
            }
            
            res.add(sb.toString());
            i = j + 1;
            
        }
        
        return res;
    }
}