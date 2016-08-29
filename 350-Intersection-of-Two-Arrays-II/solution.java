public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            }
            else {
                map.put(n, 1);
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for(int n : nums2) {
            if (map.containsKey(n)) {
                res.add(n);
                int newcount = map.get(n) - 1;
                if (newcount == 0) {
                    map.remove(n);
                }
                else {
                    map.put(n, newcount);
                }
            }
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
}