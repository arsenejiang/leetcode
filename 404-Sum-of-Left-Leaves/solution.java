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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        int res = 0;
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left != null && n.left.left == null && n.left.right == null) {
                res += n.left.val;
            }
            
            if (n.left != null) {
                q.offer(n.left);
            }
            
            if (n.right != null) {
                q.offer(n.right);
            }
        }
        
        return res;
    }
}