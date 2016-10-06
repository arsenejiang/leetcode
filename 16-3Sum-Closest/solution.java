public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                else if (sum < target) {
                    if (target - sum < minDiff) {
                        minDiff = target - sum;
                        res = sum;
                    }
                    left++;
                }
                else {
                    if (sum - target < minDiff) {
                        minDiff = sum - target;
                        res = sum;
                    }
                    right--;
                }
            }
        }
        
        return res;
    }
}