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
        int leftCount = countNodes(root.left);
        if (k <= leftCount) {
            return kthSmallest(root.left, k);
        }
        else if (k > leftCount + 1) {
            return kthSmallest(root.right, k - 1 - leftCount);
        }
        
        return root.val;
    }
    
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}