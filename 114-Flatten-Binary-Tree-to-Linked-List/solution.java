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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode cur = root;
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
            
            if (n != root) {
                cur.left = null;
                cur.right = n;
                cur = n;
            }
        }
    }
}