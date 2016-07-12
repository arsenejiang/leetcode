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
        if (inorder == null || postorder == null) {
            return null;
        }        
        
        int iLen = inorder.length;
        int pLen = postorder.length;
        if (iLen == 0 || iLen != pLen) {
            return null;
        }
        
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < iLen; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, 0, iLen - 1, postorder, 0, pLen - 1, map);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend, HashMap<Integer, Integer> map) {
        if (istart > iend || pstart > pend) {
            return null;
        }
        
        if (iend - istart != pend - pstart) {
            return null;
        }
        
        int index = map.get(postorder[pend]);
        TreeNode root == new TreeNode(postorder[pend]);
        root.left = buildTreeHelper(inorder, istart, index - 1, postorder, pstart, pstart + index - 1 - istart, map);
        root.right = buildTreeHelper(inorder, index + 1, iend, postorder, pstart + index - 1 - istart, pend - 1, map);
        
        return root;
    }
}