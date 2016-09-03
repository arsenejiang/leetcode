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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> curLevel = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (level % 2 == 0) {
                    curLevel.add(0, n.val);
                }
                else {
                    curLevel.add(n.val);
                }
                if (n.left != null) {
                    q.offer(n.left);
                }
                
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
            level++;
            res.add(curLevel);
        }
        
        return res;
        
        
    }
}