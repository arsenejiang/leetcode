public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return - 1;
        } 
        
        int len = gas.length;
        for(int i = 0; i < len; i++) {
            int curGas = 0;
            int j = 0;
            for(int j = 0; j < len; j++) {
                int index = (i + j) % len;
                curGas += gas[index] - cost[index];
                if (curGas < 0) {
                    i = index;
                    break;
                }
            }
            
            return i;
        }
        
        return -1;
    }
}