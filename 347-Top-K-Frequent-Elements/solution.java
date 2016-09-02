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
        
        Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        };
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(comp);
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
        }
        
        while(k-- > 0) {
            res.add(pq.poll().getKey());
        }
        
        return res;
    }
}