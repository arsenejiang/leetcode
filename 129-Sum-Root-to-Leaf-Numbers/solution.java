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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] result = new int[1];
        helper(root, 0, result);
        return result[0];
    }
    
    private void helper(TreeNode root, int curSum, int[] result) {
        curSum = curSum * 10  + root.val;
        if (root.left == null && root.right == null) {
            result[0] += curSum;
            return;
        }
        
        if (root.left != null) {
            helper(root.left, curSum, result);
        }
        
        if (root.right != null) {
            helper(root.right, curSum, result);
        }
    }
}