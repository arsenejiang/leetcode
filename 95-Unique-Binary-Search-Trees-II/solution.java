/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            List<TreeNode> res = new ArrayList();
            return res;
        }
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> res = new ArrayList();
        if (left > right) {
            res.add(null);
            return res;
        }
        else if (left == right) {
            TreeNode root = new TreeNode(left);
            res.add(root);
            return res;
        }
        
        for(int i = left; i <= right; i++) {
            List<TreeNode> leftList = helper(left, i - 1);
            List<TreeNode> rightList = helper(i + 1, right);
            for(TreeNode l : leftList) {
                for(TreeNode r : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}