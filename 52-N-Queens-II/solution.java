public class Solution {
    public int totalNQueens(int n) {
        int[] result = new int[1];
        int[] pos = new int[n];
        helper(pos, 0, result);
        return result[0];
    }
    
    private void helper(int[] pos, int row, int[] result) {
        if (row == pos.length) {
            result[0]++;
            return;
        }
        
        for(int i = 0; i < pos.length; i++) {
            pos[row] = i;
            if (isValid(pos, row)) {
                helper(pos, row + 1, result);
            }
        }
    }
    
    private boolean isValid(int[] pos, int row) {
        for(int i = 0; i < row; i++) {
            if (pos[i] == pos[row] || Math.abs(pos[i] - pos[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        
        return true;
    }
}