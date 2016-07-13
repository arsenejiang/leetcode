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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        
        return helper(root, 0, sum);
    }
    
    private boolean helper(TreeNode root, int cur, int sum) {
        int cur = cur + root.val;
        if (root.left == null && root.right == null) {
            return cur == sum;
        }
        
        if (root.left == null) {
            return helper(root.right, cur, sum);
        }
        else if (root.right == null) {
            return helper(root.left, cur, sum);
        }
        else {
            return helper(root.left, cur, sum) || helper(root.right, cur, sum);
        }
    }
}