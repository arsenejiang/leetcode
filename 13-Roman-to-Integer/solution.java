public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int res = 0;
        int prev = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++) {
            if (i <= s.length() - 2 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                res += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i++;
            }
            else {
                res += map.get(s.charAt(i));
            }
        }
        
        return res;
    }
}