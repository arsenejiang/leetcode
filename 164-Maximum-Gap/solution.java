public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for(int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        
        int bucketLen = (max - min) / (len - 1);
        int[][] buckets = new int[len - 1][2];
        for(int i = 0; i < len - 1; i++) {
            buckets[i][0] = Integer.MAX_VALUE;
            buckets[i][1] = Integer.MIN_VALUE;
        }
        
        for(int num : nums) {
            if (num > min && num < max) {
                int index = (num - min) / bucketLen;
                buckets[index][0] = Math.min(buckets[index][0], num);
                buckets[index][1] = Math.max(buckets[index][1], num);
            }
        }
        
        int maxGap = 0;
        int prevMax = min;
        for(int i = 0; i < len - 1; i++) {
            if (buckets[i][0] == Integer.MAX_VALUE) {
                continue;
            }
            
            maxGap = Math.max(maxGap, buckets[i][0] - prevMax);
            prevMax = buckets[i][1];
        }
        
        maxGap = Math.max(maxGap, max - prevMax);
        
        return maxGap;
    }
}