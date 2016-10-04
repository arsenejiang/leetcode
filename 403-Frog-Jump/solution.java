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
        
        return helper(gap, 1, 1);
    }
    
    private boolean helper(int[] gap, int prevVal, int curIndex) {
        if (curIndex == gap.length) {
            return true;
        }
        
        int sum = 0;
        for(int i = curIndex; i < gap.length; i++) {
            sum += gap[i];
            if (sum > prevVal + 1) {
                break;
            }
            else if (sum >= prevVal - 1) {
                if (helper(gap, sum, i + 1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}