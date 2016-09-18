public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        
        String[] strs = preorder.split(",");
        
        return isValid(strs, 0, strs.length - 1);
    }
    
    private boolean isValid(String[] strs, int start, int end) {
        if (start == end) {
            if (strs[start].equals("#")) {
                return true;
            }
            else {
                return false;
            }
        }
        
        if (strs[start].equals("#")) {
            return false;
        }
        
        for(int i = start + 1; i <= end - 1; i += 2) {
            if (isValid(strs, start + 1, i) && isValid(strs, i + 1, end)) {
                return true;
            }
        }
        
        return false;
    }
}