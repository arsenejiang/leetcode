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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
        int plen = preorder.length;
        int ilen = inorder.length;
        return helper(preorder, 0, plen - 1, inorder, 0, ilen - 1);
    }
    
    private TreeNode helper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend) {
            return null;
        }
        else if (pstart == pend) {
            return new TreeNode(preorder[pstart]);
        }
        
        TreeNode root = new TreeNode(preorder[pstart]);
        int i = istart;
        for(; i <= iend; i++) {
            if (inorder[i] == preorder[pstart]) {
                break;
            }
        }
        
        root.left = helper(preorder, pstart + 1, pstart + i - istart, inorder, istart, i - 1);
        root.right = helper(preorder, pstart + i - istart + 1, pend, inorder, i + 1, iend);
        return root;
    }
}