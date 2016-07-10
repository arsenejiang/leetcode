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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        
        return res;
    }
}