public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 3) {
            return res;
        }
        
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i <= n - 4; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = i + 1; j <= n - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int newTarget = target - (nums[i] + nums[j]);
                int l = j + 1;
                int r = n - 1;
                boolean found = false;
                while(l < r) {
                    if (found && nums[l] == nums[l-1]) {
                        l++;
                        continue;
                    }
                    int sum = nums[l] + nums[r];
                    if (sum == newTarget) {
                        Integer[] arr = new Integer[]{nums[i], nums[j], nums[l], nums[r]};
                        res.add(Arrays.asList(arr));
                        found = true;
                        l++;
                        r--;
                    }
                    else if (sum > newTarget) {
                        r--;
                    }
                    else {
                        l++;
                    }
                }
            }
        }
        
        return res;
    }
}