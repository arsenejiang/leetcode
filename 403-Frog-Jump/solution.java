public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length <= 1) {
            return true;
        }
        
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int stone : stones) {
            map.put(stone, new HashSet<Integer>());
        }
        
        map.get(stones[1]).add(1);
        
        for(int i = 2; i < stones.length; i++) {
            for(int val : map.get(stones[i-1])) {
                for(int j = Math.max(1, val - 1); j <= val + 1; j++) {
                    int nextStone = stones[i-1] + j;
                    if (nextStone == stones[stones.length - 1]) {
                        return true;
                    }
                    
                    if (map.containsKey(nextStone)) {
                        map.get(nextStone).add(j);
                    }
                }
            }
        }
        
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}