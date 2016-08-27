public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[k];
        for(int i = 0; i <= k; i++) {
            if (i <= n1 && k - i <= n2) {
                int[] tmp = merge(maxArray(nums1, i), maxArray(nums2, k - i));
                if (greater(tmp, 0, res, 0)) {
                    res = tmp;
                }
            }
        }
        
        return res;
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        
        if (j == nums2.length) {
            return true;
        }
        else if (i == nums2.length) {
            return false;
        }
        else if (nums[i] > nums[j]) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1+n2];
        int i = 0, j = 0, k = 0;
        while(k < n1 + n2) {
            res[k++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        
        return res;
    }
    
    private int[] maxArray(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        
        int[] res = new int[k];
        int n = nums.length;
        for(int i = 0, j = 0; i < n; i++) {
            while(n - i + j > k && j > 0 && res[j-1] < nums[i]) {
                j--;
            }
            
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        
        return res;
    }
}