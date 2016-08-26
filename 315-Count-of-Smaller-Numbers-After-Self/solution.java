public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int len = nums.length;
        List<Integer> sorted = new ArrayList();
        sorted.add(nums[len - 1]);
        res.add(0);
        for(int i = len - 2; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            sorted.add(index, nums[i]);
            res.add(index);
        }
        
        Collections.reverse(res);
        return res;
    }
    
    private int findIndex(List<Integer> sorted, int target) {
        int left = 0;
        int right = sorted.size() - 1;
        while(left <= right) {
            int mid = (right - left)/2 + left;
            if (sorted.get(mid) >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}