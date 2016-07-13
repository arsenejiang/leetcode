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
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        
        List<Integer> cur = new ArrayList();
        helper(root, sum, res, cur);
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> cur) {
        if(root.left == null && root.right == null) {
            if (root.val == sum) {
                cur.add(root.val);
                res.add(new ArrayList(cur));
                cur.remove(cur.size() - 1);
                return;
            }
        }
        
        if (root.left == null) {
            cur.add(root.val);
            helper(root.right, sum - root.val, res, cur);
            cur.remove(cur.size() - 1);
        }
        else if (root.right == null) {
            cur.add(root.val);
            helper(root.left, sum - root.val, res, cur);
            cur.remove(cur.size() - 1);
        }
        else {
            cur.add(root.val);
            helper(root.left, sum - root.val, res, cur);
            helper(root.right, sum - root.val, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}