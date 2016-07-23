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
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        // Set<TreeNode> visited = new HashSet();
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            res.add(0, n.val);
            if (n.left != null) {
                stack.push(n.left);
            }
            
            if (n.right != null) {
                stack.push(n.right);
            }
        }
        
        return res;
    }
}