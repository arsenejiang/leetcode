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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            while(size-- > 0) {
                TreeNode n = q.poll();
                list.add(n.val);
                if (n.left != null) {
                    q.offer(n.left);
                }
                
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
            
            res.add(list);
        }
        
        Collections.reverse(res);
        return res;
    }
}