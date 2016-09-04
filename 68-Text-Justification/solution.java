public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return res;
        }
        
        int curLen = 0;
        int start = 0;
        for(int i = 0; i < words.length; i++) {
            if (curLen + 1 + words[i].length() <= maxWidth) {
                curLen += 1 + words[i].length();
            }
            else {
                int spaceLen = maxWidth - curLen;
                int numOfGap = i - 1 - start;
                StringBuilder sb = new StringBuilder();
                int eachSpaceLen = spaceLen / numOfGap;
                int reminder = spaceLen % numOfGap;
                sb.append(words[start]);
                for(int j = start + 1; j <= i - 1; j++) {
                    for(int k = 1; k <= eachSpaceLen; k++) {
                        sb.append(" ");
                    }
                    if (reminder-- > 0) {
                        sb.append(" ");
                    }
                    
                    sb.append(" " + words[j]);
                }
                res.add(sb.toString());
                
                curLen = words[i].length();
                start = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        for(int j = start + 1; j < words.length; j++) {
            sb.append(" ");
            sb.append(words[j]);
        }
        
        if (sb.length() > 0) {
            for(int i = sb.length(); i <= maxWidth; i++) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        
        return res;
    }
}