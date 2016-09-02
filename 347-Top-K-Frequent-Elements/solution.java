public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return res;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }
        
        if (map.size() <= k) {
            res.addAll(map.keySet());
            return res;
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (buckets[e.getValue()] == null) {
                buckets[e.getValue()] = new ArrayList<Integer>();
            }
            buckets[e.getValue()].add(e.getKey());
        }
        
        for(int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
            if (buckets[i] != null) {
                res.addAll(buckets[i]);
            }
        }
        
        return res;
    }
}