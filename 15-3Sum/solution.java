public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while(j < k) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                
                if (k < len - 1 && nums[k] == nums[k+1]) {
                    k--;
                    continue;
                }
                
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    Integer[] arr = new Integer[]{nums[i], nums[j], nums[k]};
                    res.add(Arrays.asList(arr));
                    j++;
                    k--;
                }
                else if (sum < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        
        return res;
    }
}