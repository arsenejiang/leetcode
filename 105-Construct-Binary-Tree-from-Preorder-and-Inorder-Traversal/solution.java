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
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < ilen; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, plen - 1, inorder, 0, ilen - 1, map);
    }
    
    private TreeNode helper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend, HashMap<Integer, Integer>) {
        if (pstart > pend) {
            return null;
        }
        else if (pstart == pend) {
            return new TreeNode(preorder[pstart]);
        }
        
        TreeNode root = new TreeNode(preorder[pstart]);
        int index = map.get(preorder[pstart]);
        
        root.left = helper(preorder, pstart + 1, pstart + index - istart, inorder, istart, index - 1, map);
        root.right = helper(preorder, pstart + index - istart + 1, pend, inorder, index + 1, iend, map);
        return root;
    }
}