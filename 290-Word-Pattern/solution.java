public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        for(int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!arr[i].equals(map.get(c))) {
                    return false;
                }
            }
            else if (map.containsValue(arr[i])) {
                return false;
            }
            else {
                map.put(c, arr[i]);
            }
        }
        
        return true;
    }
}