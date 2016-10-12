public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for(int i = nums.length - 2; i >= 0; i--) {
            res.add(addNumber(root, nums[i]));
        }
        
        Collections.reverse(res);
        return res;
    }
    
    private int addNumber(TreeNode root, int val) {
        int curCount = 0;
        while(true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                }
                else {
                    root = root.left;
                }
            }
            else {
                curCount += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                }
                else {
                    root = root.right;
                }
            }
        }
        
        return curCount;
    }
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int count;
        TreeNode(int val) {
            this.val = val;
            this.count = 1;
        }
    }
}