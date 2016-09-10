public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k <= 0) {
            return false;
        }
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            Integer upBound = set.floor(nums[i] + t);
            Integer lowBound = set.ceiling(nums[i] - t);
            if ((upBound != null && upBound >= nums[i]) || (lowBound != null && lowBound <= nums[i])) {
                return true;
            }
            
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        
        return false;
    }
}