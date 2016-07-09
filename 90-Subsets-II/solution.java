public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> empty = new ArrayList();
        res.add(empty);
        if (nums == null || nums.length == 0) {
            return res;
        }
        int size = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            int start = (i >= 1 && nums[i] == nums[i-1]) ? size : 0;
            size = res.size();
            for(int j = start; j < size; j++) {
                List<Integer> newList = new ArrayList(res.get(j));
                newList.add(nums[i]);
                res.add(newList);
            }
        }
        
        return res;
    }
}