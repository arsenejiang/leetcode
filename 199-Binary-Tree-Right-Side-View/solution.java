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
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            res.add(q.peek().val);
            for(int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (n.right != null) {
                    q.offer(n.right);
                }
                
                if (n.left != null) {
                    q.offer(n.left);
                }
            }
        }
        
        return res;
    }
}