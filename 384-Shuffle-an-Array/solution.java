public class Solution {
    private int[] nums;
    private Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        
        int[] copy = nums.clone();
        for(int i = 1; i < nums.length; i++) {
            swap(copy, i, rand.nextInt(i + 1));
        }
        
        return copy;
    }
    
    private void swap(int[] arr, int a, int b) {
        if (a != b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */