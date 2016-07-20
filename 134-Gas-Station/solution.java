public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return - 1;
        } 
        int len = gas.length;
        for(int i = 0; i < len; i++) {
            int curGas = 0;
            int j = i;
            do {
                curGas = gas[j] - cost[j];
                j = (j + 1) % len;
            }while(curGas >= 0);
            
            if (j == i && curGas >= 0) {
                return i;
            }
            
            if (i < j) {
                i = j;
                i--;
            } 
        }
        
        return -1;
    }
}