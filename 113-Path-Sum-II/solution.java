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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        
        List<Integer> cur = new ArrayList<Integer>();
        helper(root, sum, cur, res);
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                List<Integer> list = new ArrayList<Integer>(cur);
                list.add(root.val);
                res.add(list);
                return;
            }
            else {
                return;
            }
        }
        
        cur.add(root.val);
        if (root.left != null) {
            helper(root.left, sum - root.val, cur, res);
        }
        
        if (root.right != null) {
            helper(root.right, sum - root.val, cur, res);
        }
        
        cur.remove(cur.size() - 1);
    }
}