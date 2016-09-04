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
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight, Map<Integer, Integer> map) {
        if (pLeft > pRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pLeft]);
        if (pLeft == pRight) {
            return root;
        }
        
        int index = map.get(preorder[pLeft]);
        root.left = buildTreeHelper(preorder, inorder, pLeft + 1, index - iLeft + pLeft, iLeft, index - 1, map);
        root.right = buildTreeHelper(preorder, inorder, index - iLeft + pLeft + 1, pRight, index + 1, iRight, map);
        return root;
    }
}