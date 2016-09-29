public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> empty = new ArrayList<Integer>();
        res.add(empty);
        
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
            int start = (i >= 1 && nums[i] == nums[i-1]) ? size : 0;
            size = res.size();
            for(int j = start; j < size; j++) {
                List<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        
        return res;
    }
}