public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        res.add(empty);
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        for(int num : nums) {
            int curSize = res.size();
            for(int i = 0; i < curSize; i++) {
                List<Integer> list = new ArrayList<Integer>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        
        return res;
    }
}