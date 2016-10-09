public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        
        int len = gas.length;
        List<Integer> candidates = new ArrayList<Integer>();
        for(int i = 0; i < len; i++) {
            if (gas[i] >= cost[i]) {
                candidates.add(i);
            }
        }
        
        if (candidates.size() == 0) {
            return -1;
        }
        
        for(int candidate : candidates) {
            int sum = 0;
            for(int i = 0; i < len; i++) {
                int index = (i + candidate) % len;
                sum += gas[index] - cost[index]; 
                if (sum < 0) {
                    break;
                }
            }
            
            if (sum >= 0) {
                return candidate;
            }
        }
        
        return -1;
    }
}