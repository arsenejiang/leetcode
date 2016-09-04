public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        res.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> list : res) {
                for(int j = 0; j <= list.size(); j++) {
                    List<Integer> newList = new ArrayList(list);
                    newList.add(j, nums[i]);
                    temp.add(newList);
                }
            }
            res = temp;
        }
        
        return res;
    }
}