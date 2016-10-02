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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode n = s.pop();
            if (n.left == null && n.right == null) {
                res.add(n.val);
            }
            if (n.right != null) {
                s.push(n.right);
            }
            s.push(new TreeNode(n.val));
            if (n.left != null) {
                s.push(n.left);
            }
        }
        
        return res;
    }
}