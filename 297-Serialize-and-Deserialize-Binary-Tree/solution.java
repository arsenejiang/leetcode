/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if (sb.length() > 0) {
                sb.append(',');
            }
            if (n == null) {
                sb.append('#');
            }
            else {
                sb.append(n.val);
                q.offer(n.left);
                q.offer(n.right);
            }
        }
        
        return sb.toString();   
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int index = 1;
        while(!q.isEmpty()) {
            for(int i = 0; i < q.size(); i++) {
                TreeNode n = q.poll();
                if (strs[index].equals("#")) {
                    n.left = null;
                }
                else {
                    n.left = new TreeNode(Integer.valueOf(strs[index]));
                    q.offer(n.left);
                }
                
                index++;
                
                if (strs[index].equals("#")) {
                    n.right = null;
                }
                else {
                    n.right = new TreeNode(Integer.valueOf(strs[index]));
                    q.offer(n.right);
                }
                
                index++;
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));