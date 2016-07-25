public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        Comparator<int> comp = new Comparator<int>() {
            @override
            public int compare(int a, int b) {
                String s1 = a + b;
                String s2 = b + a;
                return s1.compareTo(s2);
            }
        };
        
        Arrays.sort(nums, comp);
        StringBuilder sb = new StringBuilder();
        for(int i = nums.length - 1; i >= 0; i++) {
            sb.append(nums[i]);
        }
        
        return sb.toString();
    }
}