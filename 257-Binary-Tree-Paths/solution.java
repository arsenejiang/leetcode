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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        helper(root, "", res);
        return res;
    }
    
    private void helper(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        
        String s = path.length() > 0 ? "->" + root.val : Integer.toString(root.val);
        
        if (root.left == null && root.right == null) {
            res.add(path + s);
            return;
        }
        
        if (root.left != null) {
            helper(root.left, path + s, res);
        }
        
        if (root.right != null) {
            helper(root.right, path + s, res);
        }
    }
}