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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int height = 1;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while(left != null && right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        
        if (left == null) {
            return (1 << height)  - 1;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}