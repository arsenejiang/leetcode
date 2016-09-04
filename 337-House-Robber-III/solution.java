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
        if (root == null) {
            return 0;
        }
        
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] robHelper(TreeNode root) {
        int[] res = new int[] {0, 0};
        if (root == null) {
            return res;
        }
        
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        res[0] = root.val + left[1] + right[1]; // stole root
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // not stole root
        return res;
    }
}