public class Solution {
    public int hIndex(int[] citations) {
        int result = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            int curH = Math.min(citations[i], citations.length - i);
            result = Math.max(curH, result);
        }
        
        return result;
    }
}