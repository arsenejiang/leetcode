public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }
        
        int start = 0;
        int current = 0;
        int count = len;
        int temp = nums[current];
        while(count > 0) {
            int next = (current + k) % len;
            int val = nums[next];
            nums[next] = temp;
            temp = val;
            current = next;
            if (current == start) {
                current++;
                temp = nums[current];
                start = current;
            }
            count--;
        }
    }
}