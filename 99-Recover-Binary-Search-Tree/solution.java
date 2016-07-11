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
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode n1 = null, n2 = null;
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        TreeNode prev = null;
        
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            if (prev == null) {
                prev = cur;
            }
            else {
                if (n1 == null && prev.val > cur.val) {
                    n1 = prev;
                    n2 = cur;
                }
                else {
                    n2 = cur;
                }
            }
            cur = cur.right;
        }
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}