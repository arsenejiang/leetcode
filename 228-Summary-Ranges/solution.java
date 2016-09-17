public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
                if (i < nums.length - 1) {
                    continue;
                }
            }
            
            if (start == end) {
                res.add(Integer.toString(start));
            }
            else {
                res.add(start + "->" + end);
            }
            
            start = nums[i];
            end = nums[i];
        }
        
        return res
    }
}