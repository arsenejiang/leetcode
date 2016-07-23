public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k <= 0) {
            return false;
        }
        
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < len; i++) {
            if (map.containsKey(nums[i]) {
                int j = map.get(nums[i]);
                if (i - j <= k) {
                    return true;
                }
                else {
                    map.put(nums[i], j);
                }
            }
            else {
                map.put(nums[i], i);
            }
        }
        
        return false;
    }
}