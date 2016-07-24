/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    List<Integer> inorderList;
    int index = 0;

    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList<Integer>();
        inorder(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index != inorderList.size();
    }

    /** @return the next smallest number */
    public int next() {
        int result = inorderList.get(index);
        index++;
        return result;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */