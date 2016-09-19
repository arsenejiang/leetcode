public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        
        int len = words.length;
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                nums[i] = nums[i] | (1 << (c - 'a'));
            }
        }
        
        int max = 0;
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
}