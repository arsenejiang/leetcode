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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd, HashMap<Integer, Integer> map) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pEnd]);
        int index = map.get(postorder[pEnd]);
        root.left = buildTreeHelper(inorder, iStart, index - 1, postorder, pStart, index - 1 - iStart + pStart, map);
        root.right = buildTreeHelper(inorder, index + 1, iEnd, postorder, index - iStart + pStart, pEnd - 1, map);
        return root;
    }
}