public class Solution {
    // (50ms) maintain a sorted list, and find pos on the sorted index, pos is the res
    /*
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int len = nums.length;
        List<Integer> sorted = new ArrayList();
        sorted.add(nums[len - 1]);
        res.add(0);
        for(int i = len - 2; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            sorted.add(index, nums[i]);
            res.add(index);
        }
        
        Collections.reverse(res); //add then reverse is faster than add to first.
        return res;
    }
    
    private int findIndex(List<Integer> sorted, int target) {
        int left = 0;
        int right = sorted.size() - 1;
        while(left <= right) {
            int mid = (right - left)/2 + left;
            if (sorted.get(mid) >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    */
    
    // Build BST (10ms)
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int len = nums.length;
        TreeNode root = new TreeNode(nums[len - 1]);
        res.add(0);
        for(int i = len - 2; i >= 0; i--) {
            int count = addNode(root, nums[i]);
            res.add(count);
        }
        
        Collections.reverse(res);
        return res;
    }
    
    private int addNode(TreeNode root, int val) {
        int curCount = 0;
        while(true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                }
                else {
                    root = root.left;
                }
            }
            else {
                curCount += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                }
                else {
                    root = root.right;
                }
            }
        }
        
        return curCount;
    }
    
    private class TreeNode{
        private int val;
        private int count; // number of nodes <= cur val.
        private TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.count = 1;
        }
    }
}