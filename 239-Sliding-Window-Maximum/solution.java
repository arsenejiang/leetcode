public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        
        int len = nums.length;
        Deque<Integer> dq = new ArrayDeque();
        int[] result = new int[len - k + 1];
        int count = 0;
        for(int i = 0; i < len; i++) {
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.offerLast(i);
            
            if (i >= k - 1) {
                result[count++] = nums[dq.peekFirst()];
            }
        }
        
        return res;
    }
}