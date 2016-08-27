public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        
        if (amount == 0) {
            return 0;
        }
        
        Arrays.sort(coins);
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        helper(coins, coins.length - 1, 0, amount, res);
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
    }
    
    private void helper(int[] coins, int index, int count, int amount, int[] res) {
        if (amount < 0) {
            return;
        }
        
        if (amount == 0) {
            if (count < res[0]) {
                res[0] = count;
            }
            return;
        }
        
        for(int i = index; i >= 0; i--) {
            if (amount >= coins[i] && count + 1 < res[0]) {
                helper(coins, i, count + 1, amount - coins[i], res);
            }
        }
    }
}