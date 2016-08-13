public class Solution {
    /* sort array
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations);
        int result = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            int curH = Math.min(citations[i], citations.length - i);
            if (curH > result) {
                result = curH;
            }
        }
        
        return result;
    }
    */
    
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int len = citations.length;
        int[] h = new int[len + 1];
        for(int i = 0; i < len; i++) {
            if (citations[i] >= len) {
                h[len]++;
            }
            else {
                h[citations[i]]++;
            }
        }
        
        int result = 0;
        for(int i = len; i >= 0; i--) {
            result += h[i];
            if (result >= i) {
                return i;
            }
        }
        
        return 0;
    } 
}