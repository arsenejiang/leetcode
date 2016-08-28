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
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] helper(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // not rob root
        res[1] = root.val + left[0] + right[0]; // rob the root
        return res;
    }
}