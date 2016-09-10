public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int countA = 0;
        int countB = 0;
        int a = 0, b = 0;
        for(int num : nums) {
            if (num != b && countA == 0) {
                a = num;
                countA++;
                continue;
            }
            
            if (num != a && countB == 0) {
                b = num;
                countB++;
                continue;
            }
            
            if (num == a) {
                countA++;
            }
            else if (num == b) {
                countB++;
            }
            else {
                countA--;
                countB--;
            }
        }
        
        countA = 0;
        countB = 0;
        for(int num : nums) {
            if (num == a) {
                countA++;
            }
            else if (num == b) {
                countB++;
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        if (countA > nums.length / 3) {
            res.add(a);
        }
        
        if (countB > nums.length / 3) {
            res.add(b);
        }
        
        return res;
    }
}