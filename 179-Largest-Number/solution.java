public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] s = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            s[i] = nums[i];
        }
        
        Comparator<String> comp = new Comparator<String>() {
            @override
            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                return s1.compareTo(s2);
            }
        };
        
        Arrays.sort(s, comp);
        StringBuilder sb = new StringBuilder();
        for(int i = s.length - 1; i >= 0; i++) {
            sb.append(s[i]);
        }
        
        return sb.toString();
    }
}