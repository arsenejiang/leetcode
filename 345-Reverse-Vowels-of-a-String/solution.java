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
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        char[] arr = s.toCharArray();
        int low = 0;
        int high = arr.length - 1;
        while(low < high) {
            while(!set.contains(arr[low])) {
                low++;
                if (low == high) {
                    return new String(arr);
                }
            }
            
            while(!set.contains(arr[high])) {
                high--;
                if (low == high) {
                    return new String(arr);
                }
            }
            
            char c = arr[low];
            arr[low] = arr[high];
            arr[high] = c;
            low++;
            high--;
        }
        
        return new String(arr);
    }
}