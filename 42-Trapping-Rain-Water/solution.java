public class Solution {
    /*
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while(left <= right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            }
            else {
                res += rightMax - height[right];
                right--;
            }
        }
        
        return res;
    }
    */
    
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int[] left = new int[height.length];
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            left[i] = Math.max(max, height[i]);
            max = Math.max(max, left[i]);
        }
        
        int[] right = new int[height.length];
        max = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            right[i] = Math.max(max, height[i]);
            max = Math.max(max, right[i]);
        }
        
        int res = 0;
        for(int i = 0; i < height.length; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        
        return res;
    }
}