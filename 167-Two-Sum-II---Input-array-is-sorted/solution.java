public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }
        
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int value = numbers[left] + numbers[right];
            if (value == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            else if (value < target) {
                left++;
            }
            else {
                right--;
            }
        }
        
        return result;
    }
}