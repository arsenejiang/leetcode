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
    /*
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root == null) {
            return res;
        }
        
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        
        if (root.left != null) {
            List<String> left = binaryTreePaths(root.left);
            for(String l : left) {
                res.add(root.val + "->" + l);
            }
        }
        
        if (root.right != null) {
            List<String> right = binaryTreePaths(root.right);
            for(String r : right) {
                res.add(root.val + "->" + r);
            }
        }
        
        return res;
    }
    */
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root != null) {
            helper(root, "", res);
        }
        
        return res;
    }
    
    private void helper(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        
        if (root.left != null) {
            helper(root.left, path + root.val + "->", res);
        }
        
        if (root.right != null) {
            helper(root.right, path + root.val + "->", res);
        }
    }
}