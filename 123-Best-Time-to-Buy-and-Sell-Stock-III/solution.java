public class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i : prices) {
            release2 = Math.max(release2, hold2 + i); // the max if we've sold 2nd stock so far.
            hold2 = Math.max(hold2, release1 - i); // the max if we've bought 2nd stock so far.
            release1 = Math.max(release1, hold1 + i); // the max if we've sold 1st stock so far.
            hold1 = Math.max(hold1, -i); // the max if we've bought 1st stock so far.
        }
        
        return release2;
    }
}