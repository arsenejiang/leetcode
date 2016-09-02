public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            res = Math.max(res, (right - left) * h);
            if (h == height[left]) {
                left++;
            }
            else {
                right--;
            }
        }
        
        return res;
    }
}