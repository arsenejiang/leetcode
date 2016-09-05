public class Solution {
    // dp O(n^2)
    /*
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums.length;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
    */
    
    // binary search O(nlogn)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums.length;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            add(list, nums[i]);
        }
        
        return list.size();
    }
    
    private void add(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        if (target > list.get(right)) {
            list.add(target);
            return;
        }
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return;
            }
            else if (list.get(mid) < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        list.set(left, target);
        
    }
}