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
        TreeNode row = root;
        TreeNode cur = row;
        while(row != null) {
            TreeNode prev = null;
            TreeNode nextRow = null;
            while(cur != null) {
                if (cur.left != null && cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    }
                    else {
                        nextRow = cur.left;
                    }
                    cur.left.next = cur.right;
                    prev = cur.right;
                }
                else if (cur.left == null && cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    }
                    else {
                        nextRow = cur.right;
                    }
                    prev = cur.right;
                }
                else if (cur.left != null && cur.right == null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    }
                    else {
                        nextRow = cur.left;
                    }
                    prev = cur.left;
                }
                cur = cur.next;
            }
            row = nextRow;
        }
    }
}