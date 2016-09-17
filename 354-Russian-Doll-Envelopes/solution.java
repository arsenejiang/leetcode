public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0 || envelopes[0].length != 2) {
            return 0;
        }
        
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                else {
                    return b[1] - a[1];
                }
            }
        };
        
        Arrays.sort(envelopes, comp);
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] envelop : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelop[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            
            dp[index] = envelop[1];
            if (index == len) {
                len++;
            }
        }
        
        return len;
    }
}