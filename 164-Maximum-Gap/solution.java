public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int len = nums.length;
        int min = nums[0], max = nums[0];
        for(int i = 1; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int bucketLen = (int)Math.ceil((double)(max - min) / (len - 1));
        int[] bucketMin = new int[len - 1];
        int[] bucketMax = new int[len - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for(int i = 0; i < len; i++) {
            if (nums[i] == min || nums[i] == max) {
                continue;
            }
            
            int index = (nums[i] - min) / bucketLen;
            bucketMin[index] = Math.min(bucketMin[index], nums[i]);
            bucketMax[index] = Math.max(bucketMax[index], nums[i]);
        }
        
        int maxGap = 0;
        int previous = min;
        for(int i = 0; i < len - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            
            int gap = bucketMin[i] - previous;
            maxGap = Math.max(maxGap, gap);
            previous = bucketMax[i];
        }
        
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}