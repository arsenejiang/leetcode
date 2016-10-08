public class Solution {
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
}