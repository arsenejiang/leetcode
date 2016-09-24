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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPath(root, res);
        return res[0];
    }
    
    private int maxPath(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        
        int left = Math.max(0, maxPath(node.left, res));
        int right = Math.max(0, maxPath(node.right, res));
        res[0] = Math.max(res[0], left + right + node.val);
        return node.val + Math.max(left, right);
    }
}