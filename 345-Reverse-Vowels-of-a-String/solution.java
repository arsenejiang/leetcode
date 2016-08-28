public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        char[] arr = s.toCharArray();
        int low = 0;
        int high = arr.length - 1;
        while(low < high) {
            while(!set.contains(nums[low])) {
                low++;
                if (low == high) {
                    return;
                }
            }
            
            while(!set.contains(nums[high])) {
                high--;
                if (low == high) {
                    return;
                }
            }
            
            char c = nums[low];
            nums[low] = nums[high];
            nums[high] = c;
            low++;
            high--;
        }
        
        return new String(arr);
    }
}