public class Solution {
    public int minPatches(int[] nums, int n) {
        int miss = 1, added = 0, i = 0;
        while(miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            }
            else {
                added++;
                miss += miss;
            }
        }
        
        return added;
    }
}