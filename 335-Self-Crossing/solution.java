public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) {
            return false;
        }
        
        for(int i = 3; i < x.length; i++) {
            // 3 crossing 0
            if (x[i-1] <= x[i-3] && x[i] >= x[i-2]) {
                return true;
            }
            
            if (i >= 4) {
                // 4 crossing 0
                if (x[i-1] == x[i-3] && x[i-2] <= x[i-4] + x[i]) {
                    return true;
                }
            }
            
            if (i >= 5) {
                // 5 crossing 0
                if (x[i-1] <= x[i-3] && x[i-3] <= x[i-5] + x[i-1] && x[i-4] < x[i-2] && x[i-2] <= x[i] + x[i-4]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}