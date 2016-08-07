public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                end = nums[i];
            }
            else {
                StringBuilder sb = new StringBuilder(start);
                if (start != end) {
                    sb.append("->");
                    sb.append(end);
                }
                res.add(sb.toString());
                start = nums[i];
                end = nums[i];
            }
        }
        
        StringBuilder sb = new StringBuilder(start);
        if (start != end) {
            sb.append("->");
            sb.append(end);
        }
        res.add(sb.toString());
        
        return res;
    }
}