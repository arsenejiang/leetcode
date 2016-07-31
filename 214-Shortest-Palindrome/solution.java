public class Solution {
    public String shortestPalindrome(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        int endIndex = 0;
        for(int j = len - 1; j >= 0; j--) {
            if (isPalindrome(array, 0, j)) {
                endIndex = j;
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int j = len - 1; j > endIndex; j--) {
            sb.append(array[j]);
        }
        sb.append(s);
        
        return sb.toString();
    }
    
    private boolean isPalindrome(char[] array, int i, int j) {
        if (i == j) {
            return true;
        }
        
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        } 
        
        return true;
    }
}