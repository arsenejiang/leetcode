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
        int[] result = new int[1];
        result[0] = 0;
        maxPathDown(root, result);
        return result[0];
    }
    
    private int maxPathDown(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        int res = left + right + root.val;
        result[0] = Math.max(result[0], res);
        return res;
    }
}