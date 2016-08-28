public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return res;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }
        
        List<Integer>[] buckets = new List[nums.length];
        for(int num : map.keySet()) {
            int count = map.get(num);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<Integer>();
            }
            buckets[count].add(num);
        }
        
        for(int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
            if (buckets[i] != null) {
                res.addAll(buckets[i]);
            }
        }
        
        return res;
    }
}