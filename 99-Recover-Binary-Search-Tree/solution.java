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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        traverse(root.left);
        if (first == null && prev.val > root.val) {
            first = prev;
        }
        
        if (first != null && prev.val > root.val) {
            second = root;
        }
        
        prev = root;
        traverse(root.right);
    }
}