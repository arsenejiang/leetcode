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
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBSTHelper(TreeNode root, long floor, long ceiling) {
        if (root == null) {
            return true;
        }
        
        if (root.val > floor && root.val < ceiling) {
            return isValidBSTHelper(root.left, floor, root.val) && isValidBSTHelper(root.right, root.val, ceiling);
        }
        else {
            return false;
        }
    }
}