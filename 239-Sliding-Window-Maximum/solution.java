public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int len = nums.length;
        if (k > len) {
            return new int[0];
        }
        
        int[] res = new int[len - k + 1];
        Deque<Integer> dq = new LinkedList<Integer>();
        int count = 0;
        for(int i = 0; i < len; i++) {
            while(!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            if (i >= k - 1) {
                res[count++] = nums[dq.peek()];
            }
        }
        
        return res;
    }
}