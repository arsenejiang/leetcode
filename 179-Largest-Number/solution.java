public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        int len = nums.length;
        String[] strs = new String[len];
        for(int i = 0; i < len; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                return s1.compareTo(s2);
            }
        };
        
        Arrays.sort(strs, comp);
        
        if (strs[len - 1].charAt(0) == '0') {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = len - 1; i >= 0; i--) {
            sb.append(strs[i]);
        }
        
        return sb.toString();
    }
}