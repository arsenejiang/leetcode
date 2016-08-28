public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums1) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }
        
        for(int num: nums2) {
            if (set.contains(num)) {
                set.remove(num);
                res.add(num);
            }
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
}