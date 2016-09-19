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
            return (double)k1 / 2 + (double)k2 / 2;
        }
    }
    
    private int findKth(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
        int m = end1 - start1 + 1;
        int n = end2 - start2 + 1;
        if (m > n) {
            return findKth(nums2, nums1, start2, end2, start1, end1, k);
        }
        
        if (m == 0) {
            return nums2[k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        int part1 = Math.min(m, k / 2);
        int part2 = k - part1;
        if (nums1[start1 + part1 - 1] < nums2[start2 + part2 - 1]) {
            return findKth(nums1, nums2, start1 + part1, end1, start2, end2, k - part1);
        }
        else {
            return findKth(nums1, nums2, start1, end1, start2 + part2, end2, k - part2);
        }
    }
}