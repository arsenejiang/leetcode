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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode n = s.pop();
            res.add(n.val);
            if (n.left != null) {
                s.push(n.left);
            }
            
            if (n.right != null) {
                s.push(n.right);
            }
        }
        
        Collections.reverse(res);
        return res;
    }
}