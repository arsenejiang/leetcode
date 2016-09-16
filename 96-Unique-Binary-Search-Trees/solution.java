public class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++) {
            count += numTrees(i - 1) * numTrees(n - i);
        }
        
        return count;
    }
}