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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        
        if (min >= max || root.val <= min || root.val >= max) {
            return false;
        }
        
        return isValidBST(root.left, min, Math.min(max, root.val)) && isValidBST(root.right, Math.max(min, root.val), max);
    }
}