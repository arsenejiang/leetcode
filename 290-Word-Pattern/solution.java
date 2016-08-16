public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }
        else if (pattern == null || str == null) {
            return false;
        }
        
        char[] pArr = pattern.toCharArray();
        String[] sArr = str.split(" ");
        if (pArr.length != sArr.length) {
            return false;
        }
        
        Map<Character, String> map = new HashMap();
        for(int i = 0; i < pArr.length; i++) {
            if (map.containsKey(pArr[i])) {
                if (!map.get(pArr[i]).equals(sArr[i])) {
                    return false;
                }
            }
            else if (map.containsValue(sArr[i])) {
                return false;
            }
            else {
                map.put(pArr[i], sArr[i]);
            }
        }
        
        return true;
    }
}