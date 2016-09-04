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
        
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {
        TreeNode root = new TreeNode(preorder[pLeft]);
        if (pLeft == pRight) {
            return root;
        }
        
        int index = search(inorder, iLeft, iRight, preorder[pLeft]);
        root.left = buildTreeHelper(preorder, inorder, pLeft + 1, index - iLeft + pLeft, iLeft, index - 1);
        root.right = buildTreeHelper(preorder, inorder, index - iLeft + pLeft + 1, pRight, index + 1, iRight);
        return root;
    }
    
    private int search(int[] nums, int left, int right, int target) {
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    
}