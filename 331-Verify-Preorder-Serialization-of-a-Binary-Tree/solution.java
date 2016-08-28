public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int diff = 1;
        for(int i = 0; i < arr.length; i++) {
            diff--;
            if (diff < 0) {
                return false;
            }
            if (!arr[i].equals("#")) {
                diff += 2;
            }
        }
        
        return diff == 0;
    }
}