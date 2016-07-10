public class Solution {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        return helper(1, n, map);
    }
    
    private int helper(int left, int right, HashMap<Integer, Integer> map) {
        if (left >= right) {
            return 1;
        }
        
        if (map.containsKey(right - left + 1)) {
            return map.get(right - left + 1);
        }
        
        int result = 0;
        for(int i = left; i <= right; i++) {
            int numLeftTrees = helper(left, i - 1);
            int numRightTrees = helper(i + 1, right);
            result += numLeftTrees * numRightTrees;
        }
        
        map.put(right - left + 1, result);
        
        return result;
    }
}