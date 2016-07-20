public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return - 1;
        } 
        
        int len = gas.length;
        for(int i = 0; i < len;) {
            int curGas = gas[i] - cost[i];
            int j = (i + 1) % len;
            while(curGas >= 0) {
                curGas += gas[j] - cost[j];
                j = (j + 1) % len;
                
                if (j == i) {
                    return i;
                }
             }
             
             if (i < j) {
                i = j;
             }
        }
        
        return -1;
    }
}