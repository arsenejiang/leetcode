public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        
        int curIndex = 2;
        int index = 2;
        while(curIndex < nums.length) {
            if (nums[curIndex] == nums[index - 2]) {
                curIndex++;
            }
            else {
                nums[index++] = nums[curIndex++];
            }
        }
        
        return index;
        
    }
}