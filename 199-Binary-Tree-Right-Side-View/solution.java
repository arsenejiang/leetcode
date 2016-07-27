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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> cur = new LinkedList();
        Queue<TreeNode> next = new LinkedList();
        next.offer(root);
        while(!cur.isEmpty() || !next.isEmpty()) {
            if (cur.isEmpty()) {
                res.add(next.peek().val);
                cur = next;
                next = new LinkedList();
            }
            else {
                TreeNode n = cur.poll();
                if (n.right != null) {
                    next.offer(n.right);
                }
                
                if (n.left != null) {
                    next.offer(n.left);
                }
            }
        }
        
        return res;
    }
}