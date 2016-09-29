public class Solution {
    int[] nums;
    Random rand;
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
        for(int i = 1; i < copy.length; i++) {
            int index = rand.nextInt(i + 1);
            swap(copy, i, index);
        }
        
        return copy;
    }
    
    private void swap(int[] arr, int i, int j) {
        if(i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */