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
        if (root == null) {
            return;
        }
        
        root.next = null;
        TreeLinkNode curLevel = root;
        while(curLevel.left != null) {
            TreeLinkNode cur = curLevel;
            while(cur != null) {
                cur.left.next = cur.right;
                cur.right.next = (cur.next == null) ? null : cur.next.left;
                cur = cur.next;
            }
            
            curLevel = curLevel.left;
        }
    }
}