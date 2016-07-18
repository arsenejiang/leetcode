public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet();
        for(int n : nums) {
            set.add(n);
        }
        
        int res = 0;
        for(int i = 0; i < nums.length && !set.isEmpty(); i++) {
            if (!set.contains(nums[i]) {
                continue;
            }
            
            int curLen = 1;
            set.remove(nums[i]);
            
            int j = 1;
            while(set.contains(nums[i] + j) {
                curLen++;
                set.remove(nums[i] + j);
                j++;
            }
            
            j = 1;
            while(set.contains(nums[i] - j) {
                curLen++;
                set.remove(nums[i] - j);
                j++;
            }
            
            if (curLen > res) {
                res = curLen;
            }
        }
        
        return res;
    }
}