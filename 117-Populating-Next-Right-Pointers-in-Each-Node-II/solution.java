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
        TreeLinkNode prevLevel = root;
        
        while(true) {
            TreeLinkNode cur = prevLevel;
            TreeLinkNode nextLevel = null;
            TreeLinkNode nextCur = null;
            while(cur != null) {
                if (cur.left != null) {
                    if (nextLevel == null) {
                        nextLevel = cur.left;
                        nextCur = nextLevel;
                    }
                    else {
                        nextCur.next = cur.left;
                    }
                }
                
                if (cur.right != null) {
                    if (nextLevel == null) {
                        nextLevel = cur.right;
                        nextCur = nextLevel;
                    }
                    else {
                        nextCur.next = cur.right;
                    }
                }
                
                cur = cur.next;
            }
            
            if (nextlevel == null) {
                return;
            }
            else {
                prevLevel = nextLevel;
            }
        }
    }
}