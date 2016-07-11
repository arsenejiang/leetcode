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
        
        List<TreeNode> res = inorderTraversal(root);
        TreeNode n1 = null, n2 = null;
        for(int i = 0; i < res.size() - 1; i++) {
            if (res.get(i).val > res.get(i+1).val) {
                if (n1 == null) {
                    n1 = res.get(i);
                    n2 = res.get(i+1);
                }
                else {
                    n2 = res.get(i+1);
                }
            }
        }
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    private List<TreeNode> inorderTraversal(TreeNode root) {
        List<TreeNode> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            res.add(cur);
            cur = cur.right;
        }
        
        return res;
    }
}