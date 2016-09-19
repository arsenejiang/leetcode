public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            else {
                set.add(num);
            }
        }
        
        return false;
    }
}