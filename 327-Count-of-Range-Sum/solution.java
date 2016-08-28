public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        long[] sum = new long[len + 1];
        sum[0] = 0;
        for(int i = 0; i < len; i++) {
            sum[i + 1] += sum[i] + nums[i];
        }
        
        int result = 0;
        TreeNode root = new TreeNode(sum[0]);
        for(int i = 1; i <= len; i++) {
            result += rangeSize(root, sum[i] - upper, sum[i] - lower);
            insert(root, sum[i]);
        }
        
        return result;
    }
    
    private int rangeSize(TreeNode root, int lower, int upper) {
        int total = root.leftSize + root.count + root.rightSize;
        int smaller = countSmaller(root, lower);
        int larger = countLarger(root, upper);
        return total - smaller - larger;
    }
    
    private int countSmaller(TreeNode root, long val) {
        if (root == null) {
            return 0;
        }
        else if (root.val == val) {
            return root.leftSize;
        }
        else if (root.val < val) {
            return root.leftSize + root.count + countSmaller(root.right, val);
        }
        else {
            return countSmaller(root.left, val);
        }
    }
    
    private int countLarger(TreeNode root, long val) {
        if (root == null) {
            return 0;
        }
        else if (root.val == val) {
            return root.rightSize;
        }
        else if (root.val < val) {
            return countLarger(root.right, val);
        }
        else {
            return root.rightSize + root.count + countLarger(root.left, val);
        }
    }
    
    private void insert(TreeNode root, long val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        else if (root.val == val) {
            root.count++;
        } 
        else if (root.val > val) {
            root.leftSize++;
            insert(root.left, val);
        }
        else {
            root.rightSize++;
            insert(root.right, val);
        }
    }
    
    private class TreeNode{
        long val;
        int count;
        int leftSize;
        int rightSize;
        TreeNode left;
        TreeNode right;
        TreeNode(long val) {
            this.val = val;
            this.count = 1;
            this.leftSize = 0;
            this.rightSize = 0;
            this.left = null;
            this.right = null;
        }
    }
}