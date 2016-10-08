public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n <= 0) {
            return res;
        }
        
        int[] nums = new int[n];
        helper(nums, 0, res);
        return res;
    }
    
    private void helper(int[] nums, int index, List<List<String>> res) {
        if (index == nums.length) {
            List<String> list = new ArrayList<String>();
            for(int i = 0; i < nums.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < nums.length; j++) {
                    if (j == nums[i]) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(isValid(nums, index, i)) {
                nums[index] = i;
                helper(nums, index + 1, res);
            }
        }
    }
    
    private boolean isValid(int[] nums, int index, int val) {
        for(int i = 0; i < index; i++) {
            if (val == nums[i] || Math.abs(val - nums[i]) == index - i) {
                return false;
            }
        }
        
        return true;
    }
}