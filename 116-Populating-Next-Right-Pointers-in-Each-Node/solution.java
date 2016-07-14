/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        Queue<TreeNode> q = new LinkedList();
        root.next = null;
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left != null) {
                n.left.next = n.right;
                q.offer(n.left);
            }
            if (n.right != null) {
                n.right.next = (n.next == null) ? null : n.next.left;
                q.offer(n.right);
            }
        }
    }
}