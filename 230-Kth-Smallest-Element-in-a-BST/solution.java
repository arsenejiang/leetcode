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
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left);
        if (leftCount == k - 1) {
            return root.val;
        }
        else if (leftCount < k - 1) {
            return kthSmallest(root.right, k - leftCount - 1);
        }
        else {
            return kthSmallest(root.left, k);
        }
    }
    
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + count(root.left) + count(root.right);
    }
}