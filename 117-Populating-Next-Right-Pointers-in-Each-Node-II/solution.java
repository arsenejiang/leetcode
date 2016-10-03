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
        TreeLinkNode row = root;
        
        while(row != null) {
            TreeLinkNode prev = null;
            TreeLinkNode nextRow = null;
            TreeLinkNode cur = row;
            while(cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    }
                    else {
                        nextRow = cur.left;
                    }
                    prev = cur.left;
                }
                
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    }
                    else {
                        nextRow = cur.right;
                    }
                    prev = cur.right;
                }
                
                cur = cur.next;
            }
            
            row = nextRow;
        }
    }
}