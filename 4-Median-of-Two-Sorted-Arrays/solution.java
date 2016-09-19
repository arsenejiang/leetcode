public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 1) {
            return findKth(nums1, nums2, 0, m - 1, 0, n - 1, (m + n) / 2 + 1);
        }
        else {
            int k1 = findKth(nums1, nums2, 0, m - 1, 0, n - 1, (m + n) / 2);
            int k2 = findKth(nums1, nums2, 0, m - 1, 0, n - 1, (m + n) / 2 + 1);
            return (double)(k1 + k2) / 2;
        }
    }
    
    private int findKth(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
        if (start1 > end1) {
            return nums2[start2 + k - 1];    
        }
        else if (start2 > end2) {
            return nums1[start1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        int total = end1 - start1 + 1 + end2 - start2 + 1;
        if (k == total) {
            return Math.max(nums1[end1], nums2[end2]);
        }
        
        int m1 = Math.min(end1, start1 + k / 2);
        int m2 = Math.min(end2, start2 + k / 2);
        if (nums1[m1] < nums2[m2]) {
            return findKth(nums1, nums2, m1 + 1, end1, start2, end2, k - (m1 - start1 + 1));
        }
        else {
            return findKth(nums1, nums2, start1, end1, m2 + 1, end2, k - (m2 - start2 + 1));
        }
    }
}