public class Solution {
    public int numTrees(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        return helper(n, cache);
    }
    
    private int helper(int n, int[] cache) {
        if (cache[n] != 0) {
            return cache[n];
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++) {
            count += helper(i - 1, cache) * helper(n - i, cache);
        }
        
        cache[n] = count;
        return count;
    }
}