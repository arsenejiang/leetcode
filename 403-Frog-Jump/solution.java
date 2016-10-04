public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length <= 1) {
            return true;
        }
        
        int len = stones.length;
        int[] gap = new int[len - 1];
        for(int i = 0; i < gap.length; i++) {
            gap[i] = stones[i + 1] - stones[i];
        }
        
        if (gap[0] != 1) {
            return false;
        }
        
        List<Integer>[] dp = new ArrayList<Integer>[gap.length];
        for(int i = 0; i < gap.length; i++) {
            dp[i] = new ArrayList<Integer>();
        }
        
        for(int i = 1; i < gap.length; i++) {
            int sum = gap[i];
            for(int j = i - 1; j >= 0; j++) {
                for(int prevVal : dp[j]) {
                    if (sum >= prevVal - 1 && sum <= prevVal + 1) {
                        dp[i].add(sum);
                    }
                }
                
                sum += gap[j];
            }
        }
        
        
        return dp[gap.length - 1].size() != 0;
    }
}