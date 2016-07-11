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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (level % 2 == 1) {
                    list.add(n.val);
                }
                else {
                    list.add(0, n.val);    
                }
                
                if (n.left != null) {
                    q.poll(n.left);
                }
                
                if (n.right != null) {
                    q.poll(n.right);
                }
            }
            res.add(list);
            level++;
        }
        
        return res;
    }
}