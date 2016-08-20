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
        
        Queue<TreeNode> q = new LinkedList();
        Queue<TreeNode> nq = new LinkedList();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        int lastIndex = 0;
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left != null) {
                q.offer(n.left);
                sb.append("," + n.left.val);
                lastIndex = sb.length() - 1;
            }
            else {
                sb.append(",#");
            }
            
            if (n.right != null) {
                q.offer(n.right);
                sb.append("," + n.right.val);
                lastIndex = sb.length() - 1;
            }
            else {
                sb.append(",#");
            }
        }
        
        return sb.substring(0, lastIndex + 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        
        String[] array = data.split(",");
        int len = array.length;
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int index = 1;
        while(!q.isEmpty() && index < len) {
            TreeNode n = q.poll();
            if (!array[index].equals("#")) {
                n.left = new TreeNode(Integer.parseInt(array[index]));
                q.offer(n.left);
            }
            
            index++;
            
            if (index < len && !array[index].equals("#")) {
                n.right = new TreeNode(Integer.parseInt(array[index]));
                q.offer(n.right);
            }
            
            index++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));