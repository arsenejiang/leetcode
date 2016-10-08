public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder cur = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            nums.add(i);
        }
        helper(nums, cur, k);
        return cur.toString();
    }
    
    private void helper(List<Integer> nums, StringBuilder cur, int k) {
        if (k == 1) {
            for(int i : nums) {
                cur.append(i);
            }
            return;
        }
        
        int total = 1;
        for(int i = nums.size(); i >= 1; i--) {
            total *= i;
        }
        
        int bucketSize = total / nums.size();
        int index = k / bucketSize;
        cur.append(nums.get(index));
        nums.remove(index);
        helper(nums, cur, k - index * bucketSize);
    }
}