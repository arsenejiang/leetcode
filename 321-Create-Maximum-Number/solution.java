public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            if (i <= n1 && k - i <= n2) {
                int[] tmp = merge(maxArray(nums1, i), maxArray(nums2, k - i));
                if (greater(tmp, res)) {
                    res = tmp;
                }
            }
        }
        
        return res;
    }
    
    private boolean greater(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while(nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        
        if (i == nums1.length) {
            return true;
        }
        else {
            return nums1[i] > nums2[j];
        }
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1+n2];
        int i = 0, j = 0, k = 0;
        while(k < n1 + n2) {
            if (i < n1 && j < n2) {
                res[k++] = nums1[i] >= nums2[j] ? nums1[i++] : nums2[j++];
            }
            else if (i == n1) {
                res[k++] = nums2[j++];
            }
            else {
                res[k++] = nums1[i++];
            } 
        }
        
        return res;
    }
    
    private int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        int n = nums.length;
        for(int i = 0, j = 0; i < n; i++) {
            while(n - i + j > k && j > 0 && nums[j-1] < nums[i]) {
                j--;
            }
            
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        
        return res;
    }
}