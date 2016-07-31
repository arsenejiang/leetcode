public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while(true) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) {
                return nums[pos];
            }
            
            if (pos > k - 1) {
                right = pos - 1;
            }
            else {
                left = pos + 1;
            }
        }
    }
    
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low], i = low + 1, j = high;
        while(i <= j) {
            if (nums[i] < pivot && nums[j] > pivot) {
                swap(nums, i, j);
                i++;
                j--;
            }
            
            if (nums[i] >= pivot) {
                i++;
            }
            if (nums[j] <= pivot) {
                j--;
            }
        }
        
        swap(nums, low, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}