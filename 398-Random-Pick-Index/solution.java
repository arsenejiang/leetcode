public class Solution {
    HashMap<Integer, List<Integer>> map;
    Random rand;
    public Solution(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
        
        rand = new Random();
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int size = list.size();
        return list.get(rand.nextInt(size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */