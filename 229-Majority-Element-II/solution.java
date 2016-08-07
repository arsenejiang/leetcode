public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int candidateA = nums[0];
        int countA = 1;
        int candidateB = 0;
        int countB = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == candidateA) {
                countA++;
            }
            else if (nums[i] == candidateB) {
                countB++;
            }
            else if (countA == 0) {
                candidateA = nums[i];
                countA = 1;
            }
            else if (countB == 0) {
                candidateB = nums[i];
                countB = 1;
            }
            else {
                countA--;
                countB--;
            }
        }
        
        countA = 0;
        countB = 0;
        for(int num : nums) {
            if (num == candidateA) {
                countA++;
            }
            else if (num == candidateB) {
                countB++;
            }
        }
        
        if (countA > nums.length / 3) {
            res.add(candidateA);
        }
        
        if (countB > nums.length / 3) {
            res.add(candidateB);
        }
        
        return res;
    }
}