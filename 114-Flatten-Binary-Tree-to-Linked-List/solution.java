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
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root.right != null) {
                stack.push(root.right);
        }
        
        if (root.left != null) {
            stack.push(root.left);
        }
        
        TreeNode cur = root;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            cur.right = node;
            cur.left = null;
            cur = cur.right;
            
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}