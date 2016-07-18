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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int result = 0;
        List<StringBuilder> list = helper(root);
        for(StringBuilder sb : list) {
            result += Integer.parseInt(sb.toString());
        }
        
        return result;
    }
    
    private List<StringBuilder> helper(TreeNode root) {
        List<StringBuilder> res = new ArrayList();
        if (root == null) {
            return res;
        }
        
        res.addAll(helper(root.left));
        res.addAll(helper(root.right));
        for(StringBuilder sb : res) {
            sb.insert(0, root.val);
        }
        
        if (res.size() == 0) {
            res.add(new StringBuilder(root.val));
        }
        
        return res;
    }
}