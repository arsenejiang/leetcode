public class Solution {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        
        return helper(1, n);
    }
    
    private int helper(int left, int right) {
        if (left >= right) {
            return 1;
        }
        
        int result = 0;
        for(int i = left; i <= right; i++) {
            int numLeftTrees = helper(left, i - 1);
            int numRightTrees = helper(i + 1, right);
            result += numLeftTrees * numRightTrees;
        }
        
        return result;
    }
}